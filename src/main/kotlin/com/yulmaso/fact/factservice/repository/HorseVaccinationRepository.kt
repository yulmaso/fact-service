package com.yulmaso.fact.factservice.repository

import com.yulmaso.fact.factservice.model.Horse
import com.yulmaso.fact.factservice.model.HorseVaccination
import org.springframework.data.jpa.repository.JpaRepository

interface HorseVaccinationRepository: JpaRepository<HorseVaccination, Long> {
    fun findByHorse(horse: Horse): List<HorseVaccination>
}
