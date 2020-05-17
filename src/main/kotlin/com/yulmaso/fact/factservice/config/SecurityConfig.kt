package com.yulmaso.fact.factservice.config

import com.yulmaso.fact.factservice.jwt.JwtRequestFilter
import com.yulmaso.fact.factservice.model.enums.Role
import com.yulmaso.fact.factservice.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig: WebSecurityConfigurerAdapter() {

    @Autowired
    private var userService: UserService? = null

    @Autowired
    private var jwtRequestFilter: JwtRequestFilter? = null

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.userDetailsService(userService)
    }

    override fun configure(http: HttpSecurity?) {
        http!!
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/authenticate*").permitAll()
                    .antMatchers("/*").denyAll()
                    .anyRequest().authenticated()
                    .and()
                .exceptionHandling()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        http
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter::class.java)
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = NoOpPasswordEncoder.getInstance()

}