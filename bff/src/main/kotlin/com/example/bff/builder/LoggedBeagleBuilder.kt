package com.example.bff.builder

import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.ServerDrivenComponent
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.core.EdgeValue
import br.com.zup.beagle.widget.core.Size
import br.com.zup.beagle.widget.core.TextAlignment
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.Text


class LoggedBeagleBuilder : ScreenBuilder, ServerDrivenComponent {
    override fun build() = Screen(
            style = (Style(backgroundColor = "#11151d")),
            child = Container(
                    children = listOf(
                            Container(
                    children = listOf(
                            Text(text = "Bem vindo ao Beagle", styleId = "h1", alignment = TextAlignment.CENTER),
                            Text(text = "Framework que atualiza UI via backend", styleId = "h2", alignment = TextAlignment.CENTER),
                            Text(text = "O Beagle é uma plataforma Server-Driven para iOS, Android e Web que facilita a construção de telas por meio de um backend, permitindo que telas e fluxos nativos sejam alterados utilizando apenas JSON.", styleId = "h3", alignment = TextAlignment.CENTER),
                            Button(text = "Quero conhecer!", styleId = "loginButton", onPress = listOf(Navigate.OpenExternalURL(url = "https://usebeagle.io/"))).applyStyle(Style(backgroundColor = "#5e8602", cornerRadius = CornerRadius(25.0),margin = EdgeValue(top = 15.unitReal()), padding = EdgeValue(all = 15.unitReal()), size = Size(width = 95.unitPercent(), height = 40.unitReal())))
                            )).applyStyle(Style(backgroundColor = "#343944", margin = EdgeValue(top = 150.unitReal()), cornerRadius = CornerRadius(25.0), padding = EdgeValue(all = 15.unitReal()), size = Size(width = 100.unitPercent(), height = 450.unitReal())))
                    )).applyStyle(Style(backgroundColor = "#11151d", padding = EdgeValue(all = 15.unitReal()))
            )
    )
}