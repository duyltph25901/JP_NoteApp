package com.example.noteapp.presentation.nav

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.noteapp.model.viewmodel.HomeViewModel
import com.example.noteapp.presentation.screens.home.HomeScreen
import com.example.noteapp.presentation.screens.language.LanguageScreen
import com.example.noteapp.presentation.screens.onb.OnbScreen
import com.example.noteapp.presentation.screens.splash.SplashScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.SplashRoute.route

    ) {
        composable(
            route = Routes.SplashRoute.route
        ) {
            SplashScreen(
                navController = navController
            )
        }

        composable(
            route = Routes.LanguageRoute.route
        ) {
            LanguageScreen(
                navController = navController
            )
        }

        composable(
            route = Routes.OnbRoute.route
        ) {
            OnbScreen(
                navController = navController
            )
        }

        composable(
            route = Routes.HomeRoute.route
        ) {
            val viewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(
                viewModel = viewModel
            )
        }
    }
}