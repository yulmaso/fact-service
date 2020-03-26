package com.yulmaso.fact.factservice.service

import com.yulmaso.fact.factservice.model.Greeting

interface GreetingService {
    fun getAll(): List<Greeting>
    fun getById(id: Long): Greeting
    fun save(greeting: Greeting): Greeting
    fun remove(id:Long)
}