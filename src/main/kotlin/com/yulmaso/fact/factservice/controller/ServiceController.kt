package com.yulmaso.fact.factservice.controller

import com.yulmaso.fact.factservice.model.Horse
import com.yulmaso.fact.factservice.model.Service
import com.yulmaso.fact.factservice.service.ServiceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/services")
class ServiceController {
    @Autowired
    private var service: ServiceService? = null

    @GetMapping("/{id}")
    fun getService(@PathVariable("id") id: Long) = service!!.getById(id)

    @GetMapping
    fun getAllServices(): List<Service> = service!!.getAll()

    @Secured("ROLE_ADMIN")
    @PostMapping
    fun saveService(@RequestBody item: Service) = service!!.save(item)

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/remove/{id}")
    fun removeService(@PathVariable("id") id: Long) = service!!.remove(id)
}