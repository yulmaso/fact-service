package com.yulmaso.fact.factservice.model

import com.yulmaso.fact.factservice.model.enums.Position
import javax.persistence.*

@Entity
@Table(name = "user_positions")
@IdClass(UserPositionID::class)
class UserPosition {
    @Id
    var user: User? = null

    @Id
    var position: Position? = null

    @ManyToMany
    var horseAccesses: List<HorseAccess>? = null
}