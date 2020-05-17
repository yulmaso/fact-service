package com.yulmaso.fact.factservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.support.beans
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.web.servlet.function.ServerResponse
import org.springframework.web.servlet.function.router

@SpringBootApplication(exclude = [
    HibernateJpaAutoConfiguration::class
])
class FactServiceApplication

fun main(args: Array<String>) {
    runApplication<FactServiceApplication>(*args)
}
