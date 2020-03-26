package com.yulmaso.fact.factservice.service

import com.yulmaso.fact.factservice.model.Greeting
import com.yulmaso.fact.factservice.repository.GreetingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GreetingServiceImpl: GreetingService {

    @Autowired
    var repository: GreetingRepository? = null

    override fun getAll(): List<Greeting> = repository!!.findAll()

    override fun getById(id: Long): Greeting = repository!!.getOne(id)

    override fun save(greeting: Greeting): Greeting = repository!!.saveAndFlush(greeting)

    override fun remove(id: Long) = repository!!.deleteById(id)
}