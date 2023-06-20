package com.compose.ecommerceappcompose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AllScreens(val route:String, val title:String, val icon:ImageVector)
{
    object Home: AllScreens(route = "home_screen", title = "Home", icon = Icons.Default.Home)
    object Cart: AllScreens(route = "cart_screen", title = "Cart", icon = Icons.Default.ShoppingCart)
    object Settings: AllScreens(route = "settings_screen", title = "Settings", icon = Icons.Default.Settings)
    object Profile: AllScreens(route = "profile_screen", title = "Profile", icon = Icons.Default.Person)
    object Details: AllScreens(route = "single_product_screen/{product_id}", title = "Details",
        icon = Icons.Default.Done)
}
