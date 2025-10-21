package br.com.technosou.gestor.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI custumOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Rest API's Restful from 0 with Java, Spring Boot, Kubernets and Docker")
                .version("v1")
                .description("Rest API's Restful from 0 with Java, Spring Boot, Kubernets and Docker")
                .termsOfService("https://www.technosou.com.br")
                .license( new License()
                    .name("Apache 2.0")
                    .url("https://www.technosou.com.br"))
            );
    };
}
