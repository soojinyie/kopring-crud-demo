package com.example.test.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")  // 모든 경로에 대해 CORS 설정 적용
            .allowedOrigins("http://www.soojin.link")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
    }

    override fun configurePathMatch(configurer: PathMatchConfigurer) {
        configurer.setUseTrailingSlashMatch(false)
    }
}