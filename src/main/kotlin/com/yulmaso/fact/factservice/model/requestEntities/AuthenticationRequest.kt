package com.yulmaso.fact.factservice.model.requestEntities

import java.io.Serializable

class AuthenticationRequest(
    val username: String,
    val password: String
) : Serializable