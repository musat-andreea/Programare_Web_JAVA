package com.andreea.proiectjavafacultate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {

//    http://localhost:8080/swagger-ui.html
//    http://localhost:8080/doc.html

    //  Configuring Swagger2 core configuration docket
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)//  Specify the API type to swagger2
                    .apiInfo(apiInfo())               //  Used to define the API document summary information
                    .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.erik.proiectjavafacultate.controllers"))   //  Specify Controller package
                .paths(PathSelectors.any())       //  All Controller
                    .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title ("Background Interface API")//  Document page title
                .contact(new Contact("badcat",
                        "https://www.xxxx.com",
                        "xxxx@xxxx.com"))
                                 .description ("Background API Document")//  details
                .version("1.0.1")
                .termsOfServiceUrl("https://www.xxxx.com")
                .build();
    }

}