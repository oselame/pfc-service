package br.com.softal.pfc.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				//.apis(RequestHandlerSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("br.com.softal.pfc.controller"))
				.paths(PathSelectors.any())
				//.paths(PathSelectors.ant("/projetos/*"))
				//.paths(PathSelectors.ant("/email/*"))
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
	     return new ApiInfo(
	       "PeladaFC Services API (0.0.5)", 
	       "Api de dados do Site PeladaFC. ", 
	       "", 
	       "", 
	       new Contact("Adriano Oselame", "", "adrianooselame@gmail.com"), 
	       "", 
	       "", 
	       Collections.emptyList());
	}
}