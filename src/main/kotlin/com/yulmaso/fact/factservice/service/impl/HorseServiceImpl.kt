package com.yulmaso.fact.factservice.service.impl

import com.yulmaso.fact.factservice.model.Horse
import com.yulmaso.fact.factservice.repository.HorseRepository
import com.yulmaso.fact.factservice.service.HorseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HorseServiceImpl: HorseService {
    @Autowired
    private var repository: HorseRepository? = null

    override fun getAll(): List<Horse> = repository!!.findAll()

    override fun getById(id: Long): Horse = repository!!.getOne(id)

    override fun save(item: Horse): Horse = repository!!.saveAndFlush(item)

    override fun remove(id: Long) = repository!!.deleteById(id)
}