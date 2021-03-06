package com.yulmaso.fact.factservice.service.impl

import com.yulmaso.fact.factservice.model.Greeting
import com.yulmaso.fact.factservice.repository.GreetingRepository
import com.yulmaso.fact.factservice.service.GreetingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GreetingServiceImpl: GreetingService {

    @Autowired
    var repository: GreetingRepository? = null

    override fun getAll(): List<Greeting> = repository!!.findAll()

    override fun getById(id: Long): Greeting = repository!!.getOne(id)

    override fun save(item: Greeting): Greeting = repository!!.saveAndFlush(item)

    override fun remove(id: Long) = repository!!.deleteById(id)
}