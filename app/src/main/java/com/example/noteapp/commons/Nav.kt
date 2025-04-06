package com.example.noteapp.commons

import androidx.navigation.NavController

object Nav {

    fun moveNextScreen(
        navController: NavController,
        targetRoute: String,
        currentRoute: String = "",
        isFinish: Boolean = false,
    ) = if (isFinish) {
        navController.navigate(
            route = targetRoute
        ) {
            popUpTo(
                route = currentRoute
            ) {
                inclusive = true
            }
        }
    } else {
        navController.navigate(
            route = targetRoute
        )
    }

}