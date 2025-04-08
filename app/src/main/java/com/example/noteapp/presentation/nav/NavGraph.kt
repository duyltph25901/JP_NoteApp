package com.example.noteapp.presentation.nav

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.noteapp.commons.AppConst.ARG_KEY_FEATURE_NOTE
import com.example.noteapp.commons.AppConst.ARG_KEY_JSON_NOTE
import com.example.noteapp.commons.AppConst.FLAG_FEATURE_ADD_NOTE
import com.example.noteapp.model.viewmodel.EditorViewModel
import com.example.noteapp.model.viewmodel.HomeViewModel
import com.example.noteapp.presentation.screens.editor.EditorScreen
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
                navController = navController,
                viewModel = viewModel
            )
        }

        composable(
            route = Routes.EditorRoute.route,
            arguments = listOf(
                navArgument(
                    name = ARG_KEY_FEATURE_NOTE
                ) {
                    type = NavType.IntType
                },

                navArgument(
                    name = ARG_KEY_JSON_NOTE
                ) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val viewModel = hiltViewModel<EditorViewModel>()
            val featureType =
                backStackEntry.arguments?.getInt(ARG_KEY_FEATURE_NOTE) ?: FLAG_FEATURE_ADD_NOTE
            val jsonNoteEntity =
                backStackEntry.arguments?.getString(ARG_KEY_JSON_NOTE) ?: ""

            EditorScreen(
                navController = navController,
                viewModel = viewModel,
                featureType = featureType,
                jsonNoteEntity = jsonNoteEntity
            )
        }
    }
}