package com.yulmaso.fact.factservice.repository

import com.yulmaso.fact.factservice.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository: JpaRepository<User, Long> {
    fun findByUsername(username: String): Optional<User>
}