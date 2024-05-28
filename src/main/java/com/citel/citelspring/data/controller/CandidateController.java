package com.citel.citelspring.data.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.citel.citelspring.data.datasources.impl.CandidateDatasourceLocalImpl;
import com.citel.citelspring.data.models.candidate.CandidateModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/candidate")
public class CandidateController {
    @Autowired
    private CandidateDatasourceLocalImpl candidateRepository;

    @PostMapping()
    public ResponseEntity<Void> createCandidates(@RequestPart("file") MultipartFile file) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // Registrar o módulo JSR-310 para lidar com LocalDate
            objectMapper.registerModule(new JavaTimeModule());

            // Criar um tipo de coleção para CandidateModel
            CollectionType candidateListType = objectMapper.getTypeFactory().constructCollectionType(List.class, CandidateModel.class);

            // Desserializar o arquivo para uma lista de CandidateModel
            List<CandidateModel> candidates = objectMapper.readValue(file.getBytes(), candidateListType);

            // Iterar sobre os candidatos e criar cada um
            for (CandidateModel candidate : candidates) {
                candidateRepository.createCandidate(candidate);
            }

            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    @PutMapping()
    public ResponseEntity<Void> updateCandidates(@RequestBody List<CandidateModel> candidates) {
        for (CandidateModel candidate : candidates) {
            candidateRepository.updateCandidate(candidate);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<?> getAllCandidates() {
        return ResponseEntity.ok(candidateRepository.getAllCandidates());
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteAllCandidates() {
        candidateRepository.deleteAllCandidates();
        return ResponseEntity.ok().build();
    }

}
