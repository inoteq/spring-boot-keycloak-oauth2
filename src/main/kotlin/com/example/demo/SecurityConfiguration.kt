package com.example.demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfiguration {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain =
        http
            .authorizeHttpRequests {
                it
                    // Only allow authenticated users here
                    .requestMatchers("/private/**")
                    .fullyAuthenticated()
                    // Allow all other requests
                    .anyRequest()
                    .permitAll()
            }
            // Use OAuth 2.0 Login to handle authentication
            .oauth2Login(Customizer.withDefaults())
            .build()
}
