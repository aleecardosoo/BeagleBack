package com.example.bff.controller

import com.example.bff.service.LoginBeagleService
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping

@RestController
class HomeController(
        private val loginBeagleService: LoginBeagleService
) {
    @GetMapping("/login")
    fun getFirstScreen() = loginBeagleService.createScreenBeagle()
}

