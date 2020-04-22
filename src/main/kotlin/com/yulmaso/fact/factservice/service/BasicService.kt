package com.yulmaso.fact.factservice.service

import com.yulmaso.fact.factservice.model.Horse

interface BasicService<M, I> {
    fun getAll(): List<M>
    fun getById(id: I): M
    fun save(item: M): M
    fun remove(id: I)
}