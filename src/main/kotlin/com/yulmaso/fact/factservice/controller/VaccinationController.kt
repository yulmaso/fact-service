package com.yulmaso.fact.factservice.controller

import com.yulmaso.fact.factservice.model.Stable
import com.yulmaso.fact.factservice.model.Vaccination
import com.yulmaso.fact.factservice.service.StableService
import com.yulmaso.fact.factservice.service.VaccinationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/vaccinations")
class VaccinationController {
    @Autowired
    private var service: VaccinationService? = null

    @GetMapping("/{id}")
    fun getVaccination(@PathVariable("id") id: Long) = service!!.getById(id)

    @GetMapping
    fun getAllVaccinations(): List<Vaccination> = service!!.getAll()

    @PostMapping
    fun saveVaccination(@RequestBody item: Vaccination) = service!!.save(item)

    @DeleteMapping("/remove/{id}")
    fun removeVaccination(@PathVariable("id") id: Long) = service!!.remove(id)
}