package com.yulmaso.fact.factservice.model

import java.io.Serializable
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

class HorseServiceID: Serializable {
    @JoinColumn(name = "horse", nullable = false)
    @ManyToOne
    var horse: Horse? = null

    @JoinColumn(name = "service", nullable = false)
    @ManyToOne
    var service: Service? = null

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}