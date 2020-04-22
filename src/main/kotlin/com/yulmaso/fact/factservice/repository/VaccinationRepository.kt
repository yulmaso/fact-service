package com.yulmaso.fact.factservice.repository

import com.yulmaso.fact.factservice.model.Vaccination
import org.springframework.data.jpa.repository.JpaRepository

interface VaccinationRepository: JpaRepository<Vaccination, Long>