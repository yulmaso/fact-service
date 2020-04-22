package com.yulmaso.fact.factservice.model

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "vaccinations")
class Vaccination {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    var id: Long? = null

    @Column(name = "name", nullable = false)
    var name: String? = null

    @Column(name = "time", nullable = false)
    var time: Calendar? = null

    @Column(name = "description", nullable = true)
    var description: String? = null

    @OneToMany
    var horseVaccinations: MutableList<HorseVaccination>? = null
}