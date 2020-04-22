package com.yulmaso.fact.factservice.model

import javax.persistence.*

@Entity
@Table(name = "horse_access")
@IdClass(HorseAccessID::class)
class HorseAccess {
    @Id
    var horse: Horse? = null

    @Id
    var user: User? = null

    @ManyToOne
    var userPosition: UserPosition? = null
}