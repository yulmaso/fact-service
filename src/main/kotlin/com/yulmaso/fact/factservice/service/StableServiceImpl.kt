package com.yulmaso.fact.factservice.service

import com.yulmaso.fact.factservice.model.Stable
import com.yulmaso.fact.factservice.repository.StableRepository
import org.springframework.beans.factory.annotation.Autowired

class StableServiceImpl: StableService {
    @Autowired
    private var repository: StableRepository? = null

    override fun getAll(): List<Stable> = repository!!.findAll()

    override fun getById(id: Int): Stable = repository!!.getOne(id)

    override fun save(item: Stable): Stable = repository!!.saveAndFlush(item)

    override fun remove(id: Int) = repository!!.deleteById(id)
}