package br.com.playtips.utils

import androidx.compose.material.AlertDialog
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
actual fun AppIndicator(modifier:Modifier):Unit{
        CircularProgressIndicator(modifier = modifier,)

}