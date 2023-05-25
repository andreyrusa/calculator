package com.sanitas.calculator.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {


    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Calculation API")
                        .description("This API performs basic arithmetic operations")
                        .version("1.0")
                        .contact(new Contact().name("Andrey Ruiz").email("andreyrusa@gmail.com").url("https://github.com/andreyrusa"))
                        .license(new License().name("License of API").url("http://example.com")));
    }
}
