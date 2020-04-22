package com.yulmaso.fact.factservice.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "horse_quarantine")
class HorseQuarantine {
    @Id
    @Column(name = "horse_id")
    var horse_id: Long? = null

    @OneToOne
    @PrimaryKeyJoinColumn(name = "horse_id")
    var horse: Horse? = null

    @Column(name = "startTime", nullable = false)
    var startTime: Calendar? = null

    @Column(name = "endTime", nullable = false)
    var endTime: Calendar? = null
}