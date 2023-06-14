package com.C23PS326.icket.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Provinsi : Screen("provinsi")
    object About : Screen("about")
    object DetailBudaya : Screen("home/{budayaId}") {
        fun createRoute(rewardId: Long) = "home/$rewardId"
    }

    object DetailProvinsi : Screen("provinsi/{provinsiId}"){
        fun createRoute(provinsiId: Long) = "provinsi/$provinsiId"
    }
}
