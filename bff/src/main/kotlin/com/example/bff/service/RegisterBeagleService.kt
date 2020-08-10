package com.example.bff.service

import com.example.bff.builder.RegisterBeagleBuilder
import org.springframework.stereotype.Service

@Service
class RegisterBeagleService {
    fun createScreenBeagle() = RegisterBeagleBuilder()
}