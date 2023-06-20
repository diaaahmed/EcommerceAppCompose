package com.compose.ecommerceappcompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.compose.ecommerceappcompose.screens.*


@Composable
fun Nav(navController: NavHostController)
{
    NavHost(navController = navController, startDestination = AllScreens.Home.route)
    {

        composable(AllScreens.Home.route)
        {
            HomePage(click = {
                             navController.navigate("single_product_screen/$it")
            }, onClick ={} )
        }

        composable(AllScreens.Cart.route)
        {
            CartScreen()
        }

        composable(AllScreens.Settings.route)
        {
            SettingScreen()
        }

        composable(AllScreens.Profile.route)
        {
            ProfileScreen()
        }

        composable(AllScreens.Details.route, arguments = listOf(
            navArgument("product_id")
            {
                type = NavType.IntType
            }
        ))
        {
            DetailsScreen()
        }
    }
}