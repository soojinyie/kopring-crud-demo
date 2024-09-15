package com.example.test.service

import com.example.test.entity.Event
import com.example.test.repository.EventRepository
import org.springframework.stereotype.Service

@Service
class EventService(private val eventRepository: EventRepository) {
    //create
    fun createEvent(event: Event): Event = eventRepository.save(event)

    //read
    fun getAllEvents(): List<Event> = eventRepository.findAll()
    fun getEventById(id: String): Event = eventRepository.findById(id).orElseThrow{RuntimeException("Event not found")}
    fun getEventByEventName(eventName: String): List<Event> = eventRepository.findByEventName(eventName)

    //update
    fun updateEvent(id: String, updatedEvent: Event): Event{
        val event = getEventById(id)
        return eventRepository.save(event.copy(eventName = updatedEvent.eventName))
    }

    //delete
    fun deleteEvent(id: String) = eventRepository.deleteById(id)
}