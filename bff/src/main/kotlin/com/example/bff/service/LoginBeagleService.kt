package com.example.bff.service

import com.example.bff.builder.LoginBeagleBuilder
import org.springframework.stereotype.Service

@Service
class LoginBeagleService {
    fun createScreenBeagle() = LoginBeagleBuilder()
}