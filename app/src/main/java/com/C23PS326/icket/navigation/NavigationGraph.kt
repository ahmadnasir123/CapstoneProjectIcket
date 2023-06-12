package com.C23PS326.icket.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.C23PS326.icket.presentation.data_screen.DataScreen

@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController(),
){
    NavHost(
        navController = navController,
        startDestination = Screens.SignInScreen.route
    ){
        composable(route = Screens.SignInScreen.route) {

        }
    }
}