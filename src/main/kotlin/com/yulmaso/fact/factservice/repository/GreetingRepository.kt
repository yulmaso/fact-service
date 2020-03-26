package com.yulmaso.fact.factservice.repository

import com.yulmaso.fact.factservice.model.Greeting
import org.springframework.data.jpa.repository.JpaRepository

interface GreetingRepository: JpaRepository<Greeting, Long>