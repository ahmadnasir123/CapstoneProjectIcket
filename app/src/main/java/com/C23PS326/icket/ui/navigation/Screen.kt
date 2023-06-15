package com.C23PS326.icket.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Provinsi : Screen("provinsi")
    object About : Screen("about")
    object DetailBudaya : Screen("home/{budayaId}") {
        fun CreateRoute(budayaId: Long) = "home/$budayaId"
    }
    object DetailWisata : Screen("home/{wisataId}"){
        fun CreateRoute(wisataId: Long) = "home/$wisataId"
    }

    object DetailProvinsi : Screen("provinsi/{provinsiId}"){
        fun createRoute(provinsiId: Long) = "provinsi/$provinsiId"
    }

    object ListMakanan : Screen("makanan")

    object DetailMakanan : Screen("makanan/{makananId}"){
        fun createRoute(makananId: Long) = "makanan/$makananId"
    }
}
