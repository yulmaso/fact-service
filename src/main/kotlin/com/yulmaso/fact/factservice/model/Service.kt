package com.yulmaso.fact.factservice.model

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "services")
class Service {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    var id: Long? = null

    @Column(name = "name", nullable = false)
    var name: String? = null

    @Column(name = "price", nullable = false)
    var price: Int? = null //цена в день

    @OneToMany
    var horseServices: MutableList<HorseService>? = null
}