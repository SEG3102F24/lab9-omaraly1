package seg3x02.tempconverterapi.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.core.userdetails.UserDetailsService

@Configuration
class ApiSecurityConfig {

    @Bean
    fun userDetailsService(): UserDetailsService {
        val user1: UserDetails = User.withUsername("user1")
            .password(passwordEncoder().encode("password1"))
            .roles("USER")
            .build()

        val user2: UserDetails = User.withUsername("user2")
            .password(passwordEncoder().encode("password2"))
            .roles("USER")
            .build()

        return InMemoryUserDetailsManager(user1, user2)
    }


    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}
