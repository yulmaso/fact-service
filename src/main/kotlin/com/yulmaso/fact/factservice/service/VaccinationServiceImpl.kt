package com.yulmaso.fact.factservice.service

import com.yulmaso.fact.factservice.model.Vaccination
import com.yulmaso.fact.factservice.repository.VaccinationRepository
import org.springframework.beans.factory.annotation.Autowired

class VaccinationServiceImpl: VaccinationService {
    @Autowired
    private var repository: VaccinationRepository? = null

    override fun getAll(): List<Vaccination> = repository!!.findAll()

    override fun getById(id: Long): Vaccination = repository!!.getOne(id)

    override fun save(item: Vaccination): Vaccination = repository!!.save(item)

    override fun remove(id: Long) = repository!!.deleteById(id)
}