package com.yulmaso.fact.factservice.model

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "greeting")
class Greeting {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    var id: Long? = null

    @Column(name = "text", nullable = false, length = 50)
    var text: String? = null

    constructor()

    constructor(id: Long, text: String) {
        this.id = id
        this.text = text
    }


}