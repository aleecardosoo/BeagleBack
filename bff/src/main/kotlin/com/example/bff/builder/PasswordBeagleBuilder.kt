package com.example.bff.builder

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

class PasswordBeagleBuilder : ScreenBuilder, ServerDrivenComponent {

    data class PasswordInfo(
            val username: String,
            val password: String,
            val repeatPassword: String
    )

    override fun build() = Screen(
            style = (Style(backgroundColor = "#11151d")),
            child = Container(
                    context = ContextData(id = "passwordInfo", value = PasswordInfo(username = "", password = "", repeatPassword = "")),
                    children = listOf(
                            TextInput(placeholder = "Nome de Usuário", value = "@{PasswordInfo.password}", onChange = listOf(SetContext(contextId = "userInfo", path = "username", value = "@{onChange.value}"))),
                            TextInput(placeholder = "Senha", value = "@{PasswordInfo.password}", onChange = listOf(SetContext(contextId = "userInfo", path = "username", value = "@{onChange.value}"))),
                            TextInput(placeholder = "Repita sua senha", value = "@{PasswordInfo.repeatPassword}", onChange = listOf(SetContext(contextId = "userInfo", path = "nome", value = "@{onChange.value}"))),
                            Button(text = "OK", styleId = "loginButton", onPress = listOf(SendRequest(url = "/create-password/{username}/@{passwordInfo.repeatPassword}", method = RequestActionMethod.GET, onSuccess = listOf(Navigate.PushView(Route.Local(Screen(child = LoggedBeagleBuilder()))))))),
                            Button(text = "Home", styleId = "linkText", onPress = listOf(Navigate.ResetApplication(Route.Remote("/login")))).applyStyle(Style(backgroundColor = "#ffea19", size = Size(width = 70.unitPercent(), height = 80.unitReal())))
                    )
            ).applyStyle(Style(backgroundColor = "#11151d", padding = EdgeValue(all = 15.unitReal())))
    )
}