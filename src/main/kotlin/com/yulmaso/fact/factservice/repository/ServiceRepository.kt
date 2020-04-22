package com.yulmaso.fact.factservice.repository

import com.yulmaso.fact.factservice.model.Service
import org.springframework.data.jpa.repository.JpaRepository

interface ServiceRepository: JpaRepository<Service, Long>