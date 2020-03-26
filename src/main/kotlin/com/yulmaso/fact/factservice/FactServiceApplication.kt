package com.yulmaso.fact.factservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FactServiceApplication

fun main(args: Array<String>) {
//	SpringApplication.run(FactServiceApplication::class.java, *args)
    runApplication<FactServiceApplication>(*args)
}
