package com.yulmaso.fact.factservice.service

import com.yulmaso.fact.factservice.model.enums.Role
import com.yulmaso.fact.factservice.model.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
interface UserService: UserDetailsService, BasicService<User, Long> {

    override fun loadUserByUsername(p0: String?): UserDetails {
        return User.builder()
                .username(p0!!)
                .password("password")
                .authority(Role.ADMIN)
                .enabled(true)
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .build()
    }
}