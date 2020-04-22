package com.yulmaso.fact.factservice.service

import com.yulmaso.fact.factservice.model.Horse
import com.yulmaso.fact.factservice.model.Stable
import com.yulmaso.fact.factservice.repository.HorseRepository
import org.springframework.beans.factory.annotation.Autowired

class HorseServiceImpl: HorseService {
    @Autowired
    private var repository: HorseRepository? = null

    override fun getAll(): List<Horse> = repository!!.findAll()

    override fun getById(id: Long): Horse = repository!!.getOne(id)

    override fun save(item: Horse): Horse = repository!!.saveAndFlush(item)

    override fun remove(id: Long) = repository!!.deleteById(id)
}