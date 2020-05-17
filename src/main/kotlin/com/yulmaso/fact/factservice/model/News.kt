package com.yulmaso.fact.factservice.model

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "news")
class News {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    var id: Long? = null

    @Column(name = "title", nullable = false)
    var title: String? = null

    @Column(name = "content", nullable = false)
    var content: String? = null

    @Column(name = "time", nullable = false)
    var time: Calendar? = null
}