package com.example.bff.builder

import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.*
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.Text
import br.com.zup.beagle.widget.ui.TextInput

open class LoginBeagleBuilder : ScreenBuilder {
    data class Credentials(
            val username: String,
            val password: String
    )
    override fun build() = Screen(
            style = (Style(backgroundColor = "#11151d")),
            child = Container(context = ContextData(id = "credentials", value = Credentials(username = "",password = "")), children = listOf(Text(text = "Beagle", styleId = "titleText", alignment = TextAlignment.CENTER).applyStyle(Style(margin = EdgeValue(top = 210.unitReal(), left = 0.unitReal(), right = 0.unitReal(), bottom = 70.unitReal()))),
                    Container(children = listOf(
                            TextInput(placeholder = "Username", value = "@{credentials.username}", onChange = listOf(SetContext(contextId = "credentials", path = "username", value = "@{onChange.value}"))),
                            TextInput(placeholder = "Password", value = "@{credentials.password}", onChange = listOf(SetContext(contextId = "credentials", path = "password", value = "@{onChange.value}"))),
                            Button(text = "Login", onPress = listOf(SendRequest(url = "/logon/@{credentials.username}/@{credentials.password}", method = RequestActionMethod.GET, onSuccess = listOf(Navigate.PushView(Route.Local(Screen(child = LoggedBeagleBuilder())))))))
                                    .applyStyle(Style(backgroundColor = "#000000", cornerRadius = CornerRadius(25.0),margin = EdgeValue(top = 15.unitReal()), padding = EdgeValue(all = 15.unitReal()), size = Size(width = 95.unitPercent(), height = 40.unitReal()))),
                            Button(text = "Ainda não é usuário? Cadastre-se!!", styleId = "linkText", onPress = listOf(Navigate.PushView(Route.Local(Screen(child = RegisterBeagleBuilder())))))
                    )).applyStyle(Style(backgroundColor = "#343944", margin = EdgeValue(top = 150.unitReal()), cornerRadius = CornerRadius(25.0), padding = EdgeValue(all = 15.unitReal()), size = Size(width = 100.unitPercent(), height = 210.unitReal()))),
                    Button(text = "Esqueci minha senha.", styleId = "linkText", onPress = listOf(Navigate.PushView(Route.Local(Screen(child = PasswordBeagleBuilder())))))
            )
            ).applyStyle(Style(backgroundColor = "#11151d", padding = EdgeValue(all = 15.unitReal())))
    )
}