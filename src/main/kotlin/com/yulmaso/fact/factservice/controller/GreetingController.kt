package com.yulmaso.fact.factservice.controller

import com.yulmaso.fact.factservice.model.Greeting
import com.yulmaso.fact.factservice.repository.GreetingRepository
import com.yulmaso.fact.factservice.service.GreetingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class GreetingController {

    @Autowired
    var service: GreetingService? = null

    @GetMapping("/greetings")
    @ResponseBody
    fun getAllGreetings(): List<Greeting> = service!!.getAll()

    @GetMapping("/greetings/{id}")
    @ResponseBody
    fun getGreeting(@PathVariable("id") id: Long) = service!!.getById(id)

    @PostMapping("/greetings")
    @ResponseBody
    fun saveGreeting(@RequestBody greeting: Greeting) = service!!.save(greeting)

    @DeleteMapping("/greetings/{id}")
    @ResponseBody
    fun removeGreeting(@PathVariable("id") id: Long) = service!!.remove(id)

}