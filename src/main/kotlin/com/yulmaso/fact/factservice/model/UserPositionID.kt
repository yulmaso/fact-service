package com.yulmaso.fact.factservice.model

import com.yulmaso.fact.factservice.model.enums.Position
import java.io.Serializable
import javax.persistence.*

class UserPositionID: Serializable {
    @JoinColumn(name = "client", nullable = false)
    @ManyToOne
    var user: User? = null

    @Column(name = "position", nullable = false)
    @Enumerated(EnumType.STRING)
    var position: Position? = null

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}