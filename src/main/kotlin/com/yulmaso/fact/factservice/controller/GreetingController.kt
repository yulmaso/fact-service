package com.yulmaso.fact.factservice.controller

import com.yulmaso.fact.factservice.model.Greeting
import com.yulmaso.fact.factservice.repository.GreetingRepository
import com.yulmaso.fact.factservice.service.GreetingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/greetings")
class GreetingController {

    @Autowired
    var service: GreetingService? = null

    @GetMapping
    fun getAllGreetings(): List<Greeting> = service!!.getAll()

    @GetMapping("/{id}")
    fun getGreeting(@PathVariable("id") id: Long) = service!!.getById(id)

    @PostMapping()
    fun saveGreeting(@RequestBody greeting: Greeting) = service!!.save(greeting)

    @DeleteMapping("/remove/{id}")
    fun removeGreeting(@PathVariable("id") id: Long) = service!!.remove(id)

}