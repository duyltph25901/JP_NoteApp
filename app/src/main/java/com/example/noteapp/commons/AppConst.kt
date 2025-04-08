package com.example.noteapp.commons

object AppConst {

    // Time Delay
    internal const val TIME_DELAY_SPLASH = 3000.toLong() // 3s

    internal const val ARG_KEY_FEATURE_NOTE = "ARG_KEY_FEATURE_NOTE"
    internal const val ARG_KEY_JSON_NOTE = "ARG_KEY_JSON_NOTE"

    // Route
    internal const val SPLASH_ROUTE = "splash_screen_route"
    internal const val LANGUAGE_ROUTE = "language_screen_route"
    internal const val ONB_ROUTE = "onboarding_screen_route"
    internal const val HOME_ROUTE = "home_screen_route"
    internal const val EDITOR_ROUTE = "editor_screen_route/{$ARG_KEY_FEATURE_NOTE}/{$ARG_KEY_JSON_NOTE}"

    internal const val FLAG_FEATURE_ADD_NOTE = 0
    internal const val FLAG_FEATURE_UPDATE_NOTE = 1

    internal const val DATABASE_NAME = "NOTE_APP_DATABASE.db"
    internal const val BG_SCREEN = "#252525"
}