package com.example.demo.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
//import springfox.documentation.swagger.web.Doc;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	 @Bean
	    public Docket productApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.any())
	                .paths(paths())
	                .build()
	                .apiInfo(metaData())
	                .tags( new Tag("RawMaterials Entity", "RawMaterilas Management API"),
	                       new Tag("Stock Entity", "Stock Management API"))
	                    
	                .securitySchemes(Lists.newArrayList(apiKey()));
//	        return new Docket(DocumentationType.SWAGGER_2).select()
//	                .apis(RequestHandlerSelectors
//	                    .basePackage("com.example.com.controller"))
//	                .paths(PathSelectors.regex("/inventory/.*"))
//	                .build().apiInfo(metaData())
//	                .tags( new Tag("RawMaterials Entity", "RawMaterilas Management API"),
//                       new Tag("Stock Entity", "Stock Management API"))
//	                    
//	                .securitySchemes(Lists.newArrayList(apiKey()));
	        }
	    

	    private ApiKey apiKey() {
	        return new ApiKey("Bearer", "Authorization", "header");
	    }

	        @SuppressWarnings("unchecked")
		private Predicate<String> paths() {
	        return or(
	        		//regex("/inventory/rawMaterials/get/{id}"),
	        		//regex("/inventory/rawMaterials/update/{id}"),
	                //regex("/inventory/rawMaterials/delete/{id}"),
	                regex("/inventory/rawMaterials/add"),
	                regex("/inventory/rawMaterials"),
	                regex("/inventory/stock/add"),
	                regex("/inventory/stock"));
	        		
	        
	    }

	    private ApiInfo metaData() {
	        ApiInfo apiInfo = new ApiInfo(
	                "Inventory Management API",
	                "Restful API to manage the Inventory Management Application.",
	                "V1.0",
	                "Terms of service",
	                new Contact("Charu Aggarwal", "https://github.com", "charuagg8@gmail.com"),
	                "Apache License Version 2.0",
	                "https://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());
	        return apiInfo;
	    }

	    @Bean
	    UiConfiguration uiConfig() {
	        return UiConfigurationBuilder.builder()
	                .deepLinking(true)
	                .displayOperationId(false)
	                .defaultModelsExpandDepth(1)
	                .defaultModelExpandDepth(1)
	                .defaultModelRendering(ModelRendering.EXAMPLE)
	                .displayRequestDuration(false)
	                .docExpansion(DocExpansion.NONE)
	                .filter(false)
	                .maxDisplayedTags(null)
	                .operationsSorter(OperationsSorter.ALPHA)
	                .showExtensions(true)
	                .tagsSorter(TagsSorter.ALPHA)
	                .validatorUrl(null)
	                .build();
	    }

}