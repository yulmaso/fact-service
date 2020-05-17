package com.yulmaso.fact.factservice.controller

import com.yulmaso.fact.factservice.model.Event
import com.yulmaso.fact.factservice.service.EventService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/events")
class EventController {
    @Autowired
    private var service: EventService? = null

    @GetMapping("/{id}")
    fun getEvent(@PathVariable("id") id: Long) = service!!.getById(id)

    @GetMapping
    fun getFullTimetable(): List<Event> = service!!.getAll()

    @GetMapping("/{calendar}")
    fun getEventsOnDate(@PathVariable("calendar") calendar: Calendar) = service!!.getEventsOnDate(calendar)

    @PostMapping
    fun saveEvent(@RequestBody item: Event) = service!!.save(item)

    @DeleteMapping("/remove/{id}")
    fun removeEvent(@PathVariable("id") id: Long) = service!!.remove(id)
}