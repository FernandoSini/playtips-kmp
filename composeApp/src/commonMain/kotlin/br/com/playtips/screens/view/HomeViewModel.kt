package br.com.playtips.screens.view

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class HomeViewModel : ViewModel() {
        val loading = MutableStateFlow<Boolean>(false)
    init {

    }
}