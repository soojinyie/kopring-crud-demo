package com.example.test

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import javax.sql.DataSource

@SpringBootApplication
class TestApplication {

    @Autowired
    lateinit var dataSource: DataSource

    @Bean
    fun init() = CommandLineRunner {
        try {
            val connection = dataSource.connection
            println("Successfully connected to the database.")
            connection.close()
        } catch (e: Exception) {
            println("Failed to connect to the database:")
            e.printStackTrace()
        }
    }
}

fun main(args: Array<String>) {
	runApplication<TestApplication>(*args)
}
