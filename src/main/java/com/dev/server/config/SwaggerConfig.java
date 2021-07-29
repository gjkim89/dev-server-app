package com.dev.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;

import com.dev.server.model.Page;
import com.fasterxml.classmate.TypeResolver;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Autowired
	private TypeResolver typeResolver;
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.useDefaultResponseMessages(false)
				.alternateTypeRules(
						AlternateTypeRules.newRule(
								typeResolver.resolve(Pageable.class),
								typeResolver.resolve(Page.class)))
				.select()
					.apis(RequestHandlerSelectors
							.basePackage("com.dev.server.controller"))
					.paths(PathSelectors.any())
				.build();
	}
	
	//swagger 정보 정의
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("dev-server API")
				.description("dev-server API v1")
				.version("1.0")
				.license("gjkim89 Inc")
				.build();
	}
	
}
