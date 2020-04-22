package com.yulmaso.fact.factservice.controller

import com.yulmaso.fact.factservice.model.Service
import com.yulmaso.fact.factservice.model.Stable
import com.yulmaso.fact.factservice.service.StableService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/stables")
class StableController {
    @Autowired
    private var service: StableService? = null

    @GetMapping("/{id}")
    fun getStable(@PathVariable("id") id: Int) = service!!.getById(id)

    @GetMapping
    fun getAllStables(): List<Stable> = service!!.getAll()

    @PostMapping
    fun saveStables(@RequestBody item: Stable) = service!!.save(item)

    @DeleteMapping("/remove/{id}")
    fun removeStable(@PathVariable("id") id: Int) = service!!.remove(id)
}