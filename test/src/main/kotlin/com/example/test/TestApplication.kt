package com.example.test

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.slf4j.LoggerFactory
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication
class TestApplication : ApplicationListener<ContextRefreshedEvent> {
    private val logger = LoggerFactory.getLogger(TestApplication::class.java)

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        val requestMappingHandlerMapping = event.applicationContext.getBean(RequestMappingHandlerMapping::class.java)
        val map = requestMappingHandlerMapping.handlerMethods
        map.forEach { (key, value) -> 
            logger.info("Mapped \"${key}\" onto ${value.method}")
        }
    }
}

fun main(args: Array<String>) {
	runApplication<TestApplication>(*args)
}
