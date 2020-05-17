package com.yulmaso.fact.factservice.service

import com.yulmaso.fact.factservice.model.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import java.util.*

interface UserService: UserDetailsService, BasicService<User, Long> {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String?): UserDetails {
        val user = getByUsername(username!!)
        user.orElseThrow{UsernameNotFoundException("There's no user $username")}
        user.ifPresent { println("------------ User's role: ${it.authority?.authority}") }
        return user.get()
    }


    fun getByUsername(username: String): Optional<User>
}