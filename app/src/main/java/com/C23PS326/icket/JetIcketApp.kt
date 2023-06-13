package com.C23PS326.icket

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.C23PS326.icket.screen.DetailProvinsiScreen
import com.C23PS326.icket.ui.navigation.NavigationItem
import com.C23PS326.icket.ui.navigation.Screen
import com.C23PS326.icket.ui.screen.about.ScreenAbout
import com.C23PS326.icket.ui.screen.home.HomeScreen
import com.C23PS326.icket.ui.screen.provinsi.ProvinsiScreen
import com.C23PS326.icket.ui.theme.ICKETTheme


@Composable
fun JetIcketApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.DetailReward.route) {
                BottomBar(navController)
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToDetail = { rewardId ->
                        navController.navigate(Screen.DetailReward.createRoute(rewardId))
                    }
                )
            }
            composable(
                route = Screen.Provinsi.route,
                arguments = listOf(navArgument("wisataId") {type = NavType.LongType}),
            ) {
                val id = it.arguments?.getLong("wisataId") ?: -1L
                ProvinsiScreen(
                    wisataId = id

                )
            }
            composable(Screen.About.route) {
                ScreenAbout()
            }
            composable(
                route = Screen.DetailReward.route,
                arguments = listOf(navArgument("rewardId") { type = NavType.LongType }),
            ) {
                val id = it.arguments?.getLong("rewardId") ?: -1L
                DetailProvinsiScreen(
                    provinsiId = id,
                    navigateBack = {
                        navController.navigateUp()
                    },
                )
            }
        }

    }

}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    BottomNavigation(
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(R.string.menu_provinsi),
                icon = Icons.Default.ShoppingCart,
                screen = Screen.Provinsi
            ),
            NavigationItem(
                title = stringResource(R.string.menu_about),
                icon = Icons.Default.AccountCircle,
                screen = Screen.About
            ),
        )
        BottomNavigation {
            navigationItems.map { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title
                        )
                    },
                    label = { Text(item.title) },
                    selected = currentRoute == item.screen.route,

                    onClick = {
                        navController.navigate(item.screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun CategoryBoxPreview() {
    ICKETTheme {
    JetIcketApp()
    }
}

