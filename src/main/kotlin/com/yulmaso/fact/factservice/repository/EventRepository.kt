package com.yulmaso.fact.factservice.repository

import com.yulmaso.fact.factservice.model.Event
import org.springframework.data.jpa.repository.JpaRepository

interface EventRepository: JpaRepository<Event, Long> {
}