package com.example.noteapp.model.domain

import com.example.noteapp.R

data class OnbDomain(
    val id: Long = 0L,
    val titleRes: Int = 0,
    val desRes: Int = 0,
    val imgRes: Int = 0
) {
    companion object {
        fun getOnbs() = listOf(
            OnbDomain(id = 0L, titleRes = R.string.title_onb_1, desRes = R.string.des_onb_1, imgRes = R.drawable.img_onb_1),
            OnbDomain(id = 1L, titleRes = R.string.title_onb_2, desRes = R.string.des_onb_2, imgRes = R.drawable.img_onb_2),
            OnbDomain(id = 2L, titleRes = R.string.title_onb_3, desRes = R.string.des_onb_3, imgRes = R.drawable.img_onb_3),
        )
    }
}