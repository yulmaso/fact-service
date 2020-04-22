package com.yulmaso.fact.factservice.model

import com.yulmaso.fact.factservice.model.enums.Gender
import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "horses")
class Horse {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    var id: Long? = null

    @Column(name = "name", nullable = false)
    var name: String? = null //кличка

    @JoinColumn(name = "fk_owner", nullable = false)
    @ManyToOne(cascade = [CascadeType.ALL])
    var owner: User? = null //хозяин

    @JoinColumn(name = "fk_stable", nullable = false)
    @ManyToOne(cascade = [CascadeType.ALL])
    var stable: Stable? = null //конюшня

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    var gender: Gender? = null //пол

    @Column(name = "breed", nullable = false)
    var breed: String? = null //порода

    @Column(name = "age", nullable = false)
    var age: String? = null //возраст

    @Column(name = "isAtClub", nullable = false)
    var isAtClub: Boolean? = null //находится в клубе

    @JoinColumn(name = "fk_horseOnQuarantine", nullable = true)
    @OneToOne
    var horseOnQuarantine: HorseQuarantine? = null

    @OneToMany
    var horseAccess: MutableList<HorseAccess>? = null

    @OneToMany
    var horseServices: MutableList<HorseService>? = null

    @OneToMany
    var horseVaccinations: MutableList<HorseVaccination>? = null

    @OneToMany
    var events: List<Event>? = null
}