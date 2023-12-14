package com.example.demo

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController {
    @RequestMapping("/", "/public")
    fun publicEndpoint() = "Hello from a public endpoint!"

    @RequestMapping("/private")
    fun privateEndpoint() = "Hello from a private endpoint!"

    @RequestMapping("/private/user")
    fun userEndpoint(): String {
        val user = SecurityContextHolder.getContext().authentication.principal as OAuth2User
        return "Name: ${user.attributes["name"]}, " +
            "Email: ${user.attributes["email"]}, " +
            "Roles: ${user.attributes["roles"]}"
    }
}
