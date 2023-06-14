package com.C23PS326.icket.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Provinsi : Screen("provinsi")
    object About : Screen("about")
    object DetailReward : Screen("home/{rewardId}") {
        fun createRoute(rewardId: Long) = "home/$rewardId"
    }

    object DetailProvinsi : Screen("provinsi/{provinsiId}"){
        fun createRoute(provinsiId: Long) = "provinsi/$provinsiId"
    }
}
