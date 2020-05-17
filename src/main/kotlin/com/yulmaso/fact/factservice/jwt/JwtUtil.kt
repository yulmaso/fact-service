package com.yulmaso.fact.factservice.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.util.*
import java.util.function.Function
import kotlin.collections.HashMap

@Service
class JwtUtil {
    private val SECRET_KEY = "secret"

    fun extractUsername(token: String): String = extractClaim(token, Function { obj: Claims -> obj.subject })

    fun extractExpiration(token: String): Date = extractClaim(token, Function { obj: Claims -> obj.expiration })

    fun <T> extractClaim(token: String, claimsResolver: Function<Claims, T>): T {
        val claims: Claims = extractAllClaims(token)
        return claimsResolver.apply(claims)
    }
    private fun extractAllClaims(token: String): Claims {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).body
    }

    private fun isTokenExpired(token: String): Boolean = extractExpiration(token).before(Date())

    fun generateToken(userDetails: UserDetails): String {
        val claims: Map<String, Any> = HashMap()
        return createToken(claims, userDetails.username)
    }

    private fun createToken(claims: Map<String, Any>, subject: String): String =
            Jwts.builder()
                    .setClaims(claims)
                    .setSubject(subject)
                    .setIssuedAt(Date(System.currentTimeMillis()))
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact()

    fun validateToken(token: String, userDetails: UserDetails): Boolean {
        val username = extractUsername(token)
        return (username == userDetails.username /*&& !isTokenExpired(token)*/)
    }


}