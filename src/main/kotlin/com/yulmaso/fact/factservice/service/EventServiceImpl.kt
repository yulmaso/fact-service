package com.yulmaso.fact.factservice.service

import com.yulmaso.fact.factservice.model.Event
import com.yulmaso.fact.factservice.repository.EventRepository
import org.springframework.beans.factory.annotation.Autowired

class EventServiceImpl: EventService {
    @Autowired
    private var repository: EventRepository? = null

    override fun getAll(): List<Event> = repository!!.findAll()

    override fun getById(id: Long): Event = repository!!.getOne(id)

    override fun save(item: Event): Event = repository!!.saveAndFlush(item)

    override fun remove(id: Long) = repository!!.deleteById(id)
}