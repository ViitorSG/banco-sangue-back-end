package com.citel.citelspring.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.citel.citelspring.data.datasources.impl.CandidateDatasourceLocalImpl;
import com.citel.citelspring.data.models.candidate.CandidateModel;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("api/v1/candidates/stats")
public class CandidateStatsController {
    @Autowired
    private CandidateDatasourceLocalImpl candidateRepository;

    @GetMapping("/count-by-state")
    public Map<String, Long> getCountByState() {
        return candidateRepository.getAllCandidates().stream()
                .collect(Collectors.groupingBy(CandidateModel::getEstado, Collectors.counting()));
    }

    //todo arredondar as casas decimais do imc
    @GetMapping("/average-imc-by-age-range")
    public Map<String, Double> getAverageImcByAgeRange() {
        Map<String, List<Double>> imcByAgeRange = candidateRepository.getAllCandidates().stream()
                .collect(Collectors.groupingBy(this::getAgeRange, Collectors.mapping(this::calculateImc, Collectors.toList())));

        return imcByAgeRange.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream().mapToDouble(Double::doubleValue).average().orElse(0.0)));
    }

    @GetMapping("/obesity-percentage-by-gender")
    public Map<String, Double> getObesityPercentageByGender() {
        List<CandidateModel> candidates = candidateRepository.getAllCandidates();
        long totalMen = candidates.stream().filter(c -> "Masculino".equalsIgnoreCase(c.getSexo())).count();
        long obeseMen = candidates.stream().filter(c -> "Masculino".equalsIgnoreCase(c.getSexo()) && calculateImc(c) > 30).count();
        long totalWomen = candidates.stream().filter(c -> "Feminino".equalsIgnoreCase(c.getSexo())).count();
        long obeseWomen = candidates.stream().filter(c -> "Feminino".equalsIgnoreCase(c.getSexo()) && calculateImc(c) > 30).count();

        Map<String, Double> obesityPercentage = new HashMap<>();
        obesityPercentage.put("Masculino", totalMen == 0 ? 0 : (double) obeseMen / totalMen * 100);
        obesityPercentage.put("Feminino", totalWomen == 0 ? 0 : (double) obeseWomen / totalWomen * 100);

        return obesityPercentage;
    }

    @GetMapping("/average-age-by-blood-type")
    public Map<String, Double> averageAgeByBloodType() {
        return candidateRepository.getAllCandidates().stream()
                .collect(Collectors.groupingBy(CandidateModel::getTipo_sanguineo,
                        Collectors.averagingInt(c -> Period.between(c.getData_nasc(), LocalDate.now()).getYears())));
    }

    @GetMapping("/potential-donors-by-blood-type")
    public Map<String, Long> getPotentialDonorsByBloodType() {
        List<CandidateModel> allCandidates = candidateRepository.getAllCandidates();

        Map<String, List<String>> donorCompatibilityMap = getDonorCompatibilityMap();

        return countPotentialDonorsByType(allCandidates, donorCompatibilityMap);
    }

    private Map<String, List<String>> getDonorCompatibilityMap() {
        Map<String, List<String>> donorCompatibilityMap = new HashMap<>();
        donorCompatibilityMap.put("A+", Arrays.asList("A+", "A-", "O+", "O-"));
        donorCompatibilityMap.put("A-", Arrays.asList("A-", "O-"));
        donorCompatibilityMap.put("B+", Arrays.asList("B+", "B-", "O+", "O-"));
        donorCompatibilityMap.put("B-", Arrays.asList("B-", "O-"));
        donorCompatibilityMap.put("AB+", Arrays.asList("A+", "B+", "O+", "AB+", "A-", "B-", "O-", "AB-"));
        donorCompatibilityMap.put("AB-", Arrays.asList("A-", "B-", "O-", "AB-"));
        donorCompatibilityMap.put("O+", Arrays.asList("O+", "O-"));
        donorCompatibilityMap.put("O-", Arrays.asList("O-"));
        return donorCompatibilityMap;
    }


    private Map<String, Long> countPotentialDonorsByType(List<CandidateModel> candidates, Map<String, List<String>> donorCompatibilityMap) {
        Map<String, Long> potentialDonorsCount = new HashMap<>();
        for (String recipientType : donorCompatibilityMap.keySet()) {
            long count = candidates.stream()
                    .filter(candidate -> isEligibleDonorForRecipient(candidate.getTipo_sanguineo(), recipientType, donorCompatibilityMap))
                    .count();
            potentialDonorsCount.put(recipientType, count);
        }
        return potentialDonorsCount;
    }

    private boolean isEligibleDonorForRecipient(String donorBloodType, String recipientBloodType, Map<String, List<String>> donorCompatibilityMap) {
        return donorCompatibilityMap.get(donorBloodType).contains(recipientBloodType);
    }


    private String getAgeRange(CandidateModel candidate) {
        int age = candidate.getAge();
        int lowerBound = (age / 10) * 10;
        int upperBound = lowerBound + 9;
        return lowerBound + " a " + upperBound;
    }

    private double calculateImc(CandidateModel candidate) {
        return candidate.getPeso() / Math.pow(candidate.getAltura(), 2);
    }

    private boolean isEligibleDonorByAgeAndWeight(CandidateModel candidate) {
        int age = candidate.getAge();
        double weight = candidate.getPeso();
        return age >= 16 && age <= 69 && weight > 50;
    }
}