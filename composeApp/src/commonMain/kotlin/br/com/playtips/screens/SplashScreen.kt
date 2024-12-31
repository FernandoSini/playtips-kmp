package br.com.playtips.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.compose.rememberNavController
import br.com.playtips.screens.view.SplashViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import playtips_kmp.composeapp.generated.resources.Res
import playtips_kmp.composeapp.generated.resources.controle_background
import playtips_kmp.composeapp.generated.resources.controle_foreground
import kotlin.time.Duration.Companion.seconds

class SplashScreen() {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Content(navController: NavController) {
        val lifecycleOwner = LocalLifecycleOwner.current;
        val scope = rememberCoroutineScope()
        val splashViewModel = viewModel<SplashViewModel>() { SplashViewModel() }
        val navigator = navController

        LifecycleEventEffect(event = Lifecycle.Event.ON_START, lifecycleOwner = lifecycleOwner) {
            println("SplashScreen: ON_START")
            scope.launch {
                splashViewModel.loading.value = true

                delay(4.seconds)
                navigator.navigate("home") {
                    popUpTo("splash") { inclusive = true }
                }

                //splashViewModel.loadUserData(null)
                splashViewModel.loading.value = false

            }
        }
        Scaffold(modifier = Modifier.fillMaxSize(), containerColor = Color.Black) {


            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {

                Box(
                    modifier = Modifier.width(300.dp).height(300.dp).padding(bottom = 0.dp)
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize().padding(bottom = 0.dp),
                        painter = painterResource(resource = Res.drawable.controle_foreground),
                        contentDescription = null
                    )
                    if (splashViewModel.loading.value)
                    CircularProgressIndicator(
                        color = Color.White,
                        strokeWidth = 5.dp
                    )
                }

            }
        }
    }
}