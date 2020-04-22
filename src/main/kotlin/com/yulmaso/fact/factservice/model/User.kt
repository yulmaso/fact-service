package com.yulmaso.fact.factservice.model

import com.yulmaso.fact.factservice.model.enums.Role
import org.hibernate.annotations.GenericGenerator
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*

@Entity
@Table(name = "users")
class User : UserDetails {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    var id: Long? = null

    @Column(name = "authorities", nullable = false)
    @Enumerated(EnumType.STRING)
    private var authority: Role? = null

    @Column(nullable = false, unique = true)
    private var username: String? = null
    @Column(nullable = false)
    private var password: String? = null

    private var enabled: Boolean? = null
    private var accountNonExpired: Boolean? = null
    private var accountNonLocked: Boolean? = null
    private var credentialsNonExpired: Boolean? = null

    @OneToMany
    var positions: List<UserPosition>? = null

    @OneToMany
    var horses: List<Horse>? = null

    @OneToMany
    var events: List<Event>? = null

    constructor(id: Long?, authority: Role?, username: String?, password: String?, enabled: Boolean?, accountNonExpired: Boolean?, accountNonLocked: Boolean?, credentialsNonExpired: Boolean?) {
        this.id = id
        this.authority = authority
        this.username = username
        this.password = password
        this.enabled = enabled
        this.accountNonExpired = accountNonExpired
        this.accountNonLocked = accountNonLocked
        this.credentialsNonExpired = credentialsNonExpired
    }

    constructor()

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = arrayListOf(authority as GrantedAuthority)

    override fun getUsername(): String = username!!

    override fun getPassword(): String = password!!

    override fun isEnabled(): Boolean = enabled!!

    override fun isCredentialsNonExpired(): Boolean = credentialsNonExpired!!

    override fun isAccountNonExpired(): Boolean = accountNonExpired!!

    override fun isAccountNonLocked(): Boolean = accountNonLocked!!

    data class builder(
            private var id: Long? = null,
            private var authority: Role? = null,
            private var username: String? = null,
            private var password: String? = null,

            private var enabled: Boolean? = null,
            private var accountNonExpired: Boolean? = null,
            private var accountNonLocked: Boolean? = null,
            private var credentialsNonExpired: Boolean? = null
    ) {
        fun id(id: Long) = apply { this.id = id }
        fun authority(authority: Role) = apply { this.authority = authority }
        fun username(username: String) = apply { this.username = username }
        fun password(password: String) = apply { this.password = password }

        fun enabled(enabled: Boolean) = apply { this.enabled = enabled }
        fun accountNonExpired(accountNonExpired: Boolean) = apply { this.accountNonExpired = accountNonExpired }
        fun accountNonLocked(accountNonLocked: Boolean) = apply { this.accountNonLocked = accountNonLocked }
        fun credentialsNonExpired(credentialsNonExpired: Boolean) = apply { this.credentialsNonExpired = credentialsNonExpired }

        fun build() = User(id, authority, username, password, enabled, accountNonExpired, accountNonLocked, credentialsNonExpired)
    }
}