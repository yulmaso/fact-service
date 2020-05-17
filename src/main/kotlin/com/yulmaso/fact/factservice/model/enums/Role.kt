package com.yulmaso.fact.factservice.model.enums

import org.springframework.security.core.GrantedAuthority

enum class Role: GrantedAuthority {
    ROLE_ADMIN, // администратор
    ROLE_CL_OWNER, // хозяин клуба
    ROLE_H_OWNER, // хозяин лошади
    ROLE_USER; // пользователь

    override fun getAuthority(): String {
        return name
    }
}