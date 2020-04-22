package com.yulmaso.fact.factservice.repository

import com.yulmaso.fact.factservice.model.Stable
import org.springframework.data.jpa.repository.JpaRepository

interface StableRepository: JpaRepository<Stable, Int>