package com.example.navigasiku

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigasiku.view.FormIsi
import com.example.navigasiku.view.TampilData

enum class Navigasi {
    Formulir,
    Detail
}

@Composable
fun DataApp(navController: NavHostController = rememberNavController()) {
    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,
            modifier = Modifier.padding(paddingValues = isiRuang)
        )
        {
            composable(route = Navigasi.Formulir.name) {
                FormIsi(
                    onSubmitbtnClick = {
                        navController.navigate(route = Navigasi.Detail.name)
                    }
                )
            }
            composable(route = Navigasi.Detail.name) {
                TampilData(
                    onBackBtnClick = { cancelAndBackToFormulir(navController) }
                )
            }
        }
    }
}