package com.C23PS326.icket

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
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
import com.C23PS326.icket.ui.screen.Provinsi
import com.C23PS326.icket.ui.screen.about.ScreenAbout
import com.C23PS326.icket.ui.screen.home.HomeScreen
import com.C23PS326.icket.ui.screen.provinsi.BudayaScreen
import com.C23PS326.icket.ui.screen.provinsi.listitemwisata.WisataScreen
import com.C23PS326.icket.ui.screen.provinsi.makanan.DetailMakanan
import com.C23PS326.icket.ui.screen.provinsi.makanan.Makanan
import com.C23PS326.icket.ui.theme.ICKETTheme
import com.C23PS326.icket.ui.theme.lightblue

@Composable
fun JetIcketApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val topBarState = rememberSaveable { (mutableStateOf(true)) }

    when (currentRoute) {
        Screen.Home.route -> {
            topBarState.value = true
        }
        Screen.DetailBudaya.route -> {
            topBarState.value = false
        }
        Screen.DetailWisata.route -> {
            topBarState.value = false
        }
        Screen.DetailWisataCategori.route -> {
            topBarState.value = false
        }
        Screen.Provinsi.route -> {
            topBarState.value = false
        }
        Screen.About.route -> {
            topBarState.value = false
        }
        Screen.ListMakanan.route -> {
            topBarState.value = false
        }
    }

    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.DetailBudaya.route) {
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
            composable(Screen.Home2.route) {
                HomeScreen(
                    navigateToDetail = { budayaId ->
                        navController.navigate(Screen.DetailBudaya.createRoute(budayaId))
                    }
                )
            }
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToDetail = { wisataId ->
                        navController.navigate(Screen.DetailWisata.createRoute(wisataId))
                    }
                )
            }
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToDetail = { wisataCategoriId ->
                        navController.navigate(Screen.DetailWisataCategori.createRoute(wisataCategoriId))
                    },
                )
            }

            composable(Screen.About.route) {
                ScreenAbout()
            }

            composable(Screen.Provinsi.route) {
                Provinsi(
                    navigateToDetail = {provinsiId ->
                        navController.navigate(Screen.DetailProvinsi.createRoute(provinsiId))
                    }
                )
            }

            composable(Screen.ListMakanan.route) {
                Makanan(
                    navigateToDetail = {makananId ->
                        navController.navigate(Screen.DetailMakanan.createRoute(makananId))
                    }
                )
            }

            composable(
                route = Screen.DetailBudaya.route,
                arguments = listOf(navArgument("rewardId") { type = NavType.LongType }),
            ) {
                val id = it.arguments?.getLong("rewardId") ?: -1L
                BudayaScreen(
                    budayaId = id,
                    navigateBack = {
                        navController.navigateUp()
                    },
                )
            }

            composable(
                route = Screen.DetailWisata.route,
                arguments = listOf(navArgument("wisataId") { type = NavType.LongType }),
            ) {
                val id = it.arguments?.getLong("wisataId") ?: -1L
                WisataScreen(
                    wisataId = id,
                    navigateBack = {
                        navController.navigateUp()
                    },
                )
            }

            composable(
                route = Screen.DetailProvinsi.route,
                arguments = listOf(navArgument("provinsiId") { type = NavType.LongType }),
            ) {
                val id = it.arguments?.getLong("provinsiId") ?: -1L
                DetailProvinsiScreen(
                    provinsiId = id,
                    navigateBack = {
                        navController.navigateUp()
                    },
                    navigateToMakananPage = { navController.navigate("makanan") }
                )
            }

            composable(
                route = Screen.DetailMakanan.route,
                arguments = listOf(navArgument("makananId") { type = NavType.LongType }),
            ) {
                val id = it.arguments?.getLong("makananId") ?: -1L
                DetailMakanan(
                    makananId = id,
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
        modifier = modifier,
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
                icon = Icons.Default.LocationOn,
                screen = Screen.Provinsi
            ),
            NavigationItem(
                title = stringResource(R.string.menu_about),
                icon = Icons.Default.AccountCircle,
                screen = Screen.About
            ),
        )
        BottomNavigation(
            backgroundColor = MaterialTheme.colors.lightblue
        ) {
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

