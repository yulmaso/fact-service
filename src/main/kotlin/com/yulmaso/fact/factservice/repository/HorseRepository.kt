package com.yulmaso.fact.factservice.repository

import com.yulmaso.fact.factservice.model.Horse
import org.springframework.data.jpa.repository.JpaRepository

interface HorseRepository: JpaRepository<Horse, Long>