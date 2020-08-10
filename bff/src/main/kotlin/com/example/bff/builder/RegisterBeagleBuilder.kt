package com.example.bff.builder

import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.ServerDrivenComponent
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.*
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.core.EdgeValue
import br.com.zup.beagle.widget.core.Size
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.Text
import br.com.zup.beagle.widget.ui.TextInput

class RegisterBeagleBuilder : ScreenBuilder, ServerDrivenComponent {
    data class UserInfo(
            val username: String,
            val nome: String,
            val sobrenome: String,
            val email: String,
            val telefone: String
    )
    override fun build() = Screen(
            style = (Style(backgroundColor = "#11151d")),
            child = Container(
                    context = ContextData(id = "userInfo", value = UserInfo(username = "",nome = "", sobrenome = "", email = "", telefone = "")),
                    children = listOf(
                            Text(text = "Cadastre-se, é rápido!"),
                            Container(children = listOf(
                                    TextInput(placeholder = "Nome", value = "@{userInfo.nome}", onChange = listOf(SetContext(contextId = "userInfo", path = "nome", value = "@{onChange.value}"))),
                                    TextInput(placeholder = "Sobrenome", value = "@{userInfo.sobrenome}", onChange = listOf(SetContext(contextId = "userInfo", path = "sobrenome", value = "@{onChange.value}"))),
                                    TextInput(placeholder = "Email", value = "@{userInfo.email}", onChange = listOf(SetContext(contextId = "userInfo", path = "email", value = "@{onChange.value}"))),
                                    TextInput(placeholder = "Telefone", value = "@{userInfo.telefone}", onChange = listOf(SetContext(contextId = "userInfo", path = "telefone", value = "@{onChange.value}"))),
                                    Button(text = "Crie sua senha", styleId = "linkText", onPress = listOf(Navigate.PushView(Route.Local(Screen(child = PasswordBeagleBuilder())))))
                                            .applyStyle(Style(backgroundColor = "#5e8602", cornerRadius = CornerRadius(25.0),margin = EdgeValue(top = 15.unitReal()), padding = EdgeValue(all = 15.unitReal()), size = Size(width = 95.unitPercent(), height = 40.unitReal())))
                            )).applyStyle(Style(backgroundColor = "#343944", margin = EdgeValue(top = 150.unitReal()), cornerRadius = CornerRadius(25.0), padding = EdgeValue(all = 15.unitReal()), size = Size(width = 100.unitPercent(), height = 450.unitReal()))),
                            Button(text = "Home", styleId = "linkText", onPress = listOf(Navigate.ResetApplication(Route.Remote("/login")))))
            ).applyStyle(Style(backgroundColor = "#11151d", padding = EdgeValue(all = 15.unitReal())))
    )
}