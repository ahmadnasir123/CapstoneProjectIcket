package com.C23PS326.icket.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.C23PS326.icket.R

data class Category (
    @DrawableRes val imageCategory: Int,
    @StringRes val textCategory: Int
    )

val dummyCategory = listOf(
    R.drawable.wisata to R.string.txt_wisata,
    R.drawable.makanan to R.string.txt_makanan,
    R.drawable.tarian to R.string.txt_tarian,
    R.drawable.senjata to R.string.txt_senjata,
    R.drawable.lagu to R.string.txt_lagu,
    R.drawable.rumahadat to R.string.txt_rumah_adat,
    R.drawable.pakaian to R.string.txt_pakaian,
    R.drawable.tradisi to R.string.txt_tradisi,
).map { Category(it.first, it.second) }