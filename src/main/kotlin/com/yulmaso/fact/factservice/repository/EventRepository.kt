package com.yulmaso.fact.factservice.repository

import com.yulmaso.fact.factservice.model.Event
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.sql.Timestamp

interface EventRepository: JpaRepository<Event, Long> {

    @Query(value = "SELECT * FROM events WHERE DATE('start_time') = DATE('?1') ORDER BY start_time DESC",
            nativeQuery = true)
    fun getEventsOnDate(timestamp: Timestamp): List<Event>

    @Query(value = "SELECT * FROM events ORDER BY start_time DESC", nativeQuery = true)
    fun getAllEvents(): List<Event>
}