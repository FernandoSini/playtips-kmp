package br.com.playtips

import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.window.ComposeUIViewController
import br.com.playtips.screens.App
import br.com.playtips.screens.Home

@OptIn(ExperimentalComposeApi::class)
fun MainViewController() = ComposeUIViewController(configure = {
    enforceStrictPlistSanityCheck = false
    opaque = false
}) {

    App().Content()
}