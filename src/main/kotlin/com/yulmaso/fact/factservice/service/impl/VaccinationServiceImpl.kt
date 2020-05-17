package com.yulmaso.fact.factservice.service.impl

import com.yulmaso.fact.factservice.model.Vaccination
import com.yulmaso.fact.factservice.repository.VaccinationRepository
import com.yulmaso.fact.factservice.service.VaccinationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class VaccinationServiceImpl: VaccinationService {
    @Autowired
    private var repository: VaccinationRepository? = null

    override fun getAll(): List<Vaccination> = repository!!.findAll()

    override fun getById(id: Long): Vaccination = repository!!.getOne(id)

    override fun save(item: Vaccination): Vaccination = repository!!.save(item)

    override fun remove(id: Long) = repository!!.deleteById(id)
}