package com.yulmaso.fact.factservice.model.enums

import org.springframework.security.core.GrantedAuthority

enum class Role: GrantedAuthority {
    ADMIN, // администратор
    CL_OWNER, // хозяин клуба
    H_OWNER, // хозяин лошади
    USER; // пользователь

    override fun getAuthority(): String {
        return name
    }
}