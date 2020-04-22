package com.yulmaso.fact.factservice.service

import com.yulmaso.fact.factservice.model.Service
import com.yulmaso.fact.factservice.model.Stable
import com.yulmaso.fact.factservice.repository.ServiceRepository
import org.springframework.beans.factory.annotation.Autowired

class ServiceServiceImpl: ServiceService {
    @Autowired
    private var repository: ServiceRepository? = null

    override fun getAll(): List<Service> = repository!!.findAll()

    override fun getById(id: Long): Service = repository!!.getOne(id)

    override fun save(item: Service): Service = repository!!.saveAndFlush(item)

    override fun remove(id: Long) = repository!!.deleteById(id)
}