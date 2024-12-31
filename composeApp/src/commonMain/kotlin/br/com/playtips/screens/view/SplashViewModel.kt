package br.com.playtips.screens.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.playtips.controllers.AuthController
import br.com.playtips.services.impl.AuthServiceImpl
import com.russhwolf.settings.Settings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class SplashViewModel : ViewModel() {

    var loading: MutableStateFlow<Boolean>;
    var isLoading: StateFlow<Boolean>;
    private var settings: Settings;
    private var authController: AuthController;


    init {
        authController = AuthController(AuthServiceImpl())
        settings = Settings();
        loading = MutableStateFlow(false)
        isLoading = loading.asStateFlow()
    }

    fun loadUserData(body: Map<String, String>?) {
        //settings.clear()
        viewModelScope.launch {
            val response = authController.fetchUserData(null)
            when (response) {
                is Boolean -> {
                    loading.value = response
            //    Res.drawable.conrt
                }

            }
        }
    }
}