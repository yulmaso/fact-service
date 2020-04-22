package com.yulmaso.fact.factservice.repository

import com.yulmaso.fact.factservice.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>