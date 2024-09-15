package com.example.test.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.springframework.data.annotation.CreatedDate

@Entity
data class Event (
    @Id val id : String,
    var eventName : String,
)