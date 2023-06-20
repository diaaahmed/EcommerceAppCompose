package com.compose.ecommerceappcompose

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*

import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoundedApp()
        }
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun RoundedApp() {
        
        val navController = rememberNavController()

        var selectedIndex by remember { mutableStateOf(0) }

        val items = listOf(
            AllScreens.Home,AllScreens.Cart,AllScreens.Profile,AllScreens.Settings
        )

        Scaffold(
            bottomBar = {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                val currentContext = LocalContext.current

                BottomNavigation {
                    items.forEach{screens->
                        BottomNavigationItem(
                            icon = { Icon(imageVector = screens.icon, contentDescription = null) },
                            label = { Text(text = screens.title)},
                            selected = currentRoute == screens.route,
                            onClick = {
                                navController.navigate(screens.route){
                                    // To home back directly
                                    popUpTo(navController.graph.findStartDestination().id){
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true

                                }

                                Toast.makeText(currentContext, screens.title, Toast.LENGTH_SHORT).show()
                            }
                        )
                    }
                }
            }
        ) {
            Nav(navController = navController)
        }

        // Nav host between navController and navGraph

//        NavHost(navController = navController, startDestination = "products_screen")
//        {
//
//            composable(route = "products_screen")
//            {
//                HomePage(click = {
//                    navController.navigate("single_product_screen/$it")
//                }, onClick = {
//                    when(it)
//                    {
//                        1-> navController.navigate("cart_screen")
//                        2-> navController.navigate("settings_screen")
//                        3-> navController.navigate("profile_screen")
//                        else -> navController.navigate("products_screen")
//                    }
//                })
////                HomePage {
////                    navController.navigate("single_product_screen/$it")
////                }
//            }
//
//            composable(route = "profile_screen")
//            {
//                ProfileScreen()
//            }
//
//            composable(route = "cart_screen")
//            {
//                CartScreen()
//            }
//
//            composable(route = "settings_screen")
//            {
//                SettingScreen()
//            }
//
//            composable(
//                route = "single_product_screen/{product_id}", arguments = listOf(
//                    navArgument("product_id"){
//                        type = NavType.IntType
//                    }
//                )
//            )
//            {
//                DetailsScreen()
//            }
//        }
    }
}
