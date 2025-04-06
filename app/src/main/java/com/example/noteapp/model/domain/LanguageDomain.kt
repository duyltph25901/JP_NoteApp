package com.example.noteapp.model.domain

import com.example.noteapp.R

data class LanguageDomain(
    val id: Long = 0L,
    val languageName: String = "",
    val isoCode: String = "",
    val icFlagRes: Int = 0
) {
    companion object {
        fun getLanguages() = listOf(
            LanguageDomain(id = 0L, languageName = "Vietnamese", isoCode = "", icFlagRes = R.drawable.ic_language_vietnamese),
            LanguageDomain(id = 1L, languageName = "English", isoCode = "", icFlagRes = R.drawable.ic_language_english),
            LanguageDomain(id = 2L, languageName = "Hindi", isoCode = "", icFlagRes = R.drawable.ic_language_hindi),
            LanguageDomain(id = 3L, languageName = "Spanish", isoCode = "", icFlagRes = R.drawable.ic_language_spanish),
            LanguageDomain(id = 4L, languageName = "French", isoCode = "", icFlagRes = R.drawable.ic_language_france),
        )
    }
}