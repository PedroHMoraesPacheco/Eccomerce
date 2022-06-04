package com.example.Eccomerce.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfoBuilder().title("Documentação da Api Eccomerce")
				.description("Projeto Final API Rest Serratec - Prof.: André Luiz"
						+ "\nDesenvolvedores:"
						+ "\nBárbara Espenchidt"
						+ "\nJoão Bernardes"
						+ "\nLuiz Felipe"
						+ "\nMaria Aparecida Tavares de Oliveira Souza"
						+ "\nPedro")
				.license("Apache License Version 2.0")
				.version("1.0.0")
				.build();
		return apiInfo;	
	}
	
}
