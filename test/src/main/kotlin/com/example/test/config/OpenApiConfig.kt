package com.example.test.config

import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.OpenAPI
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Event API")
                    .version("1.0.0")
                    .description("Kopring으로 만든 Event CRUD API 문서")
            )
    }
}