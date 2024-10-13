package com.example.test.controller

import com.example.test.entity.Event
import com.example.test.service.EventService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.slf4j.LoggerFactory

@RestController
@RequestMapping("/api/events")
class EventController(private val eventService: EventService) {
    private val logger = LoggerFactory.getLogger(EventController::class.java)

    init {
        logger.info("EventController initialized with base path: /api/events")
    }

    //create
    @Operation(summary = "새 이벤트 생성", description = "새로운 이벤트를 생성합니다.")
    @PostMapping
    fun createEvent(@RequestBody event:Event): ResponseEntity<Event> = ResponseEntity.ok(eventService.createEvent(event))

    //read
    @Operation(summary = "모든 이벤트 조회", description = "데이터베이스에 있는 모든 이벤트를 조회합니다.")
    @GetMapping
    fun getAllEvents(): ResponseEntity<List<Event>> {
        logger.info("GET request received at /api/events")
        return ResponseEntity.ok(eventService.getAllEvents())
    }

    @Operation(summary = "특정 이벤트 조회", description = "ID를 기반으로 특정 이벤트를 조회합니다.")
    @GetMapping("/{id}")
    fun getEventById(@PathVariable id: String): ResponseEntity<Event> = ResponseEntity.ok(eventService.getEventById(id))

    @Operation(summary = "특정 이벤트 조회", description = "eventName을 기반으로 특정 이벤트를 조회합니다.")
    @GetMapping("/search/{eventName}")
    fun getEventByEventName(@PathVariable eventName: String): ResponseEntity<List<Event>> = ResponseEntity.ok(eventService.getEventByEventName(eventName))

    //update
    @Operation(summary = "이벤트 수정", description = "ID를 기반으로 이벤트를 수정합니다.")
    @PutMapping("/{id}")
    fun updateEvent(@PathVariable id: String, @RequestBody event: Event): ResponseEntity<Event> = ResponseEntity.ok(eventService.updateEvent(id, event))

    //delete
    @Operation(summary = "이벤트 삭제", description = "ID를 기반으로 이벤트를 삭제합니다.")
    @DeleteMapping("/{id}")
    fun deleteEvent(@PathVariable id: String): ResponseEntity<Void>{
        eventService.deleteEvent(id)
        return ResponseEntity.noContent().build()
    }
}
