package com.yulmaso.fact.factservice.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@Configuration
@EnableWebSecurity
class SecurityConfig: WebSecurityConfigurerAdapter() {

//    @Autowired
//    private var userService: UserService? = null

    override fun configure(http: HttpSecurity?) {
        http!!
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().defaultSuccessUrl("/greetings", true).permitAll()
                .and()
                .logout().logoutRequestMatcher(AntPathRequestMatcher("/logout")).permitAll()
    }

//    @Autowired
//    fun configureGlobal(auth: AuthenticationManagerBuilder) {
//        auth.userDetailsService(userService)
//    }

    @Bean
    override fun userDetailsService(): UserDetailsService {
        val userDetails = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build()
        return InMemoryUserDetailsManager(userDetails)
    }

}