package com.example.test.repository

import com.example.test.entity.Event
import org.springframework.data.jpa.repository.JpaRepository

interface EventRepository: JpaRepository<Event, String>{
    fun findByEventName(eventName: String): List<Event>
}