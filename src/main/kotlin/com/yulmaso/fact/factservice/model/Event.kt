package com.yulmaso.fact.factservice.model

import com.yulmaso.fact.factservice.model.enums.Event
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "events")
class Event {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    var id: Long? = null

    @ManyToOne
    @JoinColumn(name = "horse", nullable = false)
    var horse: Horse? = null

    @ManyToOne
    @JoinColumn(name = "trainer", nullable = false)
    var trainer: User? = null

    @Column(name = "startTime", nullable = false)
    var startTime: Calendar? = null

    @Column(name = "endTime", nullable = false)
    var endTime: Calendar? = null

    @Column(name = "enabled", nullable = true)
    var enabled: Boolean? = null

    @Column(name = "event_type", nullable = false)
    @Enumerated(EnumType.STRING)
    var eventType: Event? = null
}