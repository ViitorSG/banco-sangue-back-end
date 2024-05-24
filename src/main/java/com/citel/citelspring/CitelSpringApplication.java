package com.citel.citelspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CitelSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitelSpringApplication.class, args);
	}

	// @Bean
	// BeanFactoryPostProcessor
	// beanFactoryPostProcessor(ConfigurableApplicationContext beanRegistry) {
	// return beanFactory -> {
	// genericApplicationContext(
	// (BeanDefinitionRegistry) beanRegistry.getBeanFactory());
	// };
	// }

	// void genericApplicationContext(BeanDefinitionRegistry beanRegistry) {
	// ClassPathBeanDefinitionScanner beanDefinitionScanner = new
	// ClassPathBeanDefinitionScanner(beanRegistry);
	// beanDefinitionScanner.addIncludeFilter(removeModelAndEntitiesFilter());
	// beanDefinitionScanner.scan("com.citel");
	// }

	// static TypeFilter removeModelAndEntitiesFilter() {
	// return (MetadataReader mr,
	// MetadataReaderFactory mrf) ->
	// !mr.getClassMetadata().getClassName().endsWith("Model");
	// }
}
