package com.example.noteapp.presentation.nav

import com.example.noteapp.commons.AppConst.HOME_ROUTE
import com.example.noteapp.commons.AppConst.LANGUAGE_ROUTE
import com.example.noteapp.commons.AppConst.ONB_ROUTE
import com.example.noteapp.commons.AppConst.SPLASH_ROUTE

sealed class Routes(val route: String) {

    data object SplashRoute: Routes(route = SPLASH_ROUTE)
    data object LanguageRoute: Routes(route = LANGUAGE_ROUTE)
    data object OnbRoute: Routes(route = ONB_ROUTE)
    data object HomeRoute: Routes(route = HOME_ROUTE)

}