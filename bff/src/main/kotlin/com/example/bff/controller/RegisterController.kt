package com.example.bff.controller

import com.example.bff.service.RegisterBeagleService
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping

@RestController
class RegisterController(
        private val homeBeagleService: RegisterBeagleService
) {
    @GetMapping("/register")
    fun getFirstScreen() = homeBeagleService.createScreenBeagle()
}
