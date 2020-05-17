package com.yulmaso.fact.factservice.jwt

import com.yulmaso.fact.factservice.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtRequestFilter: OncePerRequestFilter() {

    @Autowired
    var userService: UserService? = null

    @Autowired
    var jwtUtil: JwtUtil? = null

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        val authorizationHeader = request.getHeader("Authorization")

        var username: String? = null
        var jwt: String? = null

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7)
            username = jwtUtil!!.extractUsername(jwt)
        }

        if (username != null /*&& SecurityContextHolder.getContext().authentication == null*/) {
            val userDetails = userService!!.loadUserByUsername(username)
            if (jwtUtil!!.validateToken(jwt!!, userDetails)) {
                println(":::::::::::::::::::User authority - ${userDetails.authorities}")
                val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.authorities
                )
                usernamePasswordAuthenticationToken.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = usernamePasswordAuthenticationToken
                println(":::::::::::::::::::Set authority - ${SecurityContextHolder.getContext().authentication.authorities}")
            }
        }

        chain.doFilter(request, response)
    }
}