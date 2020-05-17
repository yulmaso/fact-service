package com.yulmaso.fact.factservice.controller

import com.yulmaso.fact.factservice.model.Horse
import com.yulmaso.fact.factservice.service.HorseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/horses")
class HorseController {
    @Autowired
    private var service: HorseService? = null

    @GetMapping("/{id}")
    fun getHorse(@PathVariable("id") id: Long) = service!!.getById(id)

    @GetMapping
    fun getAllHorses(): List<Horse> = service!!.getAll()

    @Secured("ROLE_ADMIN", "ROLE_H_OWNER")
    @PostMapping
    fun saveHorse(@RequestBody horse: Horse) = service!!.save(horse)

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/remove/{id}")
    fun removeHorse(@PathVariable("id") id: Long) = service!!.remove(id)
}