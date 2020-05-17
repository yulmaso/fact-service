package com.yulmaso.fact.factservice.service.impl

import com.yulmaso.fact.factservice.model.Event
import com.yulmaso.fact.factservice.repository.EventRepository
import com.yulmaso.fact.factservice.service.EventService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.util.*

@Service
class EventServiceImpl: EventService {
    @Autowired
    private var repository: EventRepository? = null

    override fun getAll(): List<Event> = repository!!.getAllEvents()

    override fun getById(id: Long): Event = repository!!.getOne(id)

    override fun save(item: Event): Event = repository!!.saveAndFlush(item)

    override fun remove(id: Long) = repository!!.deleteById(id)

    override fun getEventsOnDate(calendar: Calendar) = repository!!.getEventsOnDate(Timestamp(calendar.timeInMillis))
}