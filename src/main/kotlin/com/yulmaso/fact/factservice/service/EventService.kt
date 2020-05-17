package com.yulmaso.fact.factservice.service

import com.yulmaso.fact.factservice.model.Event
import java.util.*

interface EventService: BasicService<Event, Long> {
    fun getEventsOnDate(calendar: Calendar): List<Event>
}