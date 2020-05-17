package com.yulmaso.fact.factservice.controller

import com.yulmaso.fact.factservice.model.requestEntities.AuthenticationRequest
import com.yulmaso.fact.factservice.model.requestEntities.AuthenticationResponse
import com.yulmaso.fact.factservice.service.UserService
import com.yulmaso.fact.factservice.jwt.JwtUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/authenticate")
class AuthenticationController {
    @Autowired
    private var authenticationManager: AuthenticationManager? = null

    @Autowired
    private var jwtUtil: JwtUtil? = null

    @Autowired
    private var userService: UserService? = null

    @PostMapping
    @Throws(Exception::class)
    fun createAuthenticationToken(@RequestBody authenticationRequest: AuthenticationRequest): ResponseEntity<*>? {
        println("------------ Authenticating user" )

        try {
            authenticationManager?.authenticate(
                    UsernamePasswordAuthenticationToken(authenticationRequest.username, authenticationRequest.password)
            )
        } catch (e: BadCredentialsException) {
            throw Exception("Incorrect username or password", e)
        }

        val userDetails = userService!!.loadUserByUsername(authenticationRequest.username)

        val jwt = jwtUtil!!.generateToken(userDetails)

        return ResponseEntity.ok(AuthenticationResponse(jwt))
    }
}