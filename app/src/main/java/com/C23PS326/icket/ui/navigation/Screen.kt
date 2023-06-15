package com.C23PS326.icket.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Provinsi : Screen("provinsi")
    object About : Screen("about")
    object DetailBudaya : Screen("home/{budayaId}") {
        fun createRoute(budayaId: Long) = "home/$budayaId"
    }
    object DetailWisata : Screen("home/{wisataId}"){
        fun createRoute(wisataId: Long) = "home/$wisataId"
    }
    object DetailWisataCategori : Screen("home/{wisataCategoriId}"){
        fun createRoute(wisataCategoriId: Long) = "home/$wisataCategoriId"
    }

    object DetailProvinsi : Screen("provinsi/{provinsiId}"){
        fun createRoute(provinsiId: Long) = "provinsi/$provinsiId"
    }
}
