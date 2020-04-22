package com.yulmaso.fact.factservice.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "horse_services")
@IdClass(HorseServiceID::class)
class HorseService {
    @Id
    var horse: Horse? = null

    @Id
    var service: Service? = null

    @Column(name = "startTime", nullable = false)
    var startTime: Calendar? = null

    @Column(name = "endTime", nullable = false)
    var endTime: Calendar? = null
}