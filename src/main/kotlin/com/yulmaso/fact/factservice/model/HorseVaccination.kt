package com.yulmaso.fact.factservice.model

import javax.persistence.*

@Entity
@Table(name = "horse_vaccinations")
@IdClass(HorseVaccinationID::class)
class HorseVaccination {
    @Id
    var horse: Horse? = null

    @Id
    var vaccination: Vaccination? = null

    @Column(name = "is_done", nullable = false)
    var isDone: Boolean? = null

    @Column(name = "is_enabled", nullable = false)
    var isEnabled: Boolean? = null
}