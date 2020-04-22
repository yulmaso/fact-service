package com.yulmaso.fact.factservice.model

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "stables")
class Stable {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    var id: Int? = null

    @Column(name = "name", nullable = false)
    var name: String? = null

    @OneToMany
    var horses: MutableList<Horse>? = null
}