package com.example.bff.controller

import com.example.bff.service.UserBeagleService
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

data class Params(@PathVariable("username") val username: String)

@RestController
class UserController(
        private val userBeagleService: UserBeagleService
) {
    @GetMapping("/find/{username}")
    fun findUser(@PathVariable ("username") username: String) = userBeagleService.findUser(username)

    @GetMapping("/add-user/{nome}/{sobrenome}/{email}/{telefone}")
    fun addUser(
             @PathVariable ("nome") nome: String,
             @PathVariable ("sobrenome") sobrenome: String,
             @PathVariable ("email") email: String,
             @PathVariable ("telefone") telefone: String)
            = userBeagleService.addUser(nome, sobrenome, email, telefone)

    @GetMapping("/create-password/{username}/{password}/{repeatPassword}")
    fun findUser(@PathVariable ("username") username: String,
                 @PathVariable ("password") password: String,
                 @PathVariable ("repeatPassword") repeatPassword: String) = userBeagleService.createPassword(username, password, repeatPassword)

    @GetMapping("/logon/{username}/{password}")
    fun findUser(@PathVariable ("username") username: String,
                 @PathVariable ("password") password: String) = userBeagleService.loginUser(username, password)

}

