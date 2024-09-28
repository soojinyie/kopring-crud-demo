package com.example.test.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Event (
    @Id val id : String,
    var eventName : String,
)