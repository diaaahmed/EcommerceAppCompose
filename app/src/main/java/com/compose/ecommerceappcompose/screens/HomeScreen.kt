package com.compose.ecommerceappcompose.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.compose.ecommerceappcompose.entity.BottomNavigationItem
import com.compose.ecommerceappcompose.entity.ProductsItem
import com.compose.ecommerceappcompose.ui.theme.Purple200
import com.compose.ecommerceappcompose.ui.theme.Purple500
import com.compose.ecommerceappcompose.viewmodel.MainViewModel
import com.compose.newsappcompose.R

@Composable
fun HomeScreen(click:(Int) -> Unit)
{
    val mainViewModel:MainViewModel = hiltViewModel()

    LazyVerticalGrid(columns = GridCells.Fixed(2),
    contentPadding = PaddingValues(bottom = 15.dp)
    )
    {
        items(mainViewModel.state){
                product->
            ProductItem(item = product, click = click)
        }
    }
//    LazyColumn()
//    {
//
//        items(mainViewModel.state){product->
//            ProductItem(item = product, click = click)
//        }
//    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomePage(click: (Int) -> Unit, onClick:(Int)-> Unit)
{
    HomeScreen(click = click)
//    var selectedIndex by remember { mutableStateOf(0) }
//
//    val items = listOf(
//        BottomNavigationItem(Icons.Filled.Home, "Home"),
//        BottomNavigationItem(Icons.Filled.ShoppingCart, "Cart"),
//        BottomNavigationItem(Icons.Filled.Settings, "Settings"),
//        BottomNavigationItem(Icons.Filled.Person, "Profile"),
//    )
//
//    Scaffold(
//        bottomBar = {
//            BottomNavigationCreate(
//                items = items,
//                selectedIndex = selectedIndex,
//                onSelectedIndexChanged = { index ->
//                    selectedIndex = index
//                },
//                click = {
//                    onClick(it)
//                }
//            )
//        },
//        topBar = {
//        TopAppBar(
//            modifier = Modifier
//                .padding(vertical = 10.dp, horizontal = 16.dp)
//                .fillMaxWidth()
//                .clip(
//                    shape = RoundedCornerShape(16.dp)
//                ),
//            backgroundColor = colorResource(id = R.color.purple_500),
//            title = { Box(modifier = Modifier.fillMaxWidth(),
//                Alignment.Center){
//                Text(text = "Ecommerce App")
//            } },
//            navigationIcon = {
//                IconButton(onClick = { /* Handle navigation icon click */ }) {
//                    Icon(Icons.Default.Menu, contentDescription = "Menu")
//                }
//            },
//            actions = {
//                Row {
//                    IconButton(onClick = { /* Handle action 1 click */ }) {
//                        Icon(Icons.Default.Favorite, contentDescription = "Favorite")
//                    }
//                    IconButton(onClick = { /* Handle action 2 click */ }) {
//                        Icon(Icons.Default.Share, contentDescription = "Share")
//                    }
//                }
//            }, elevation = 8.dp
//        )
//    },content = {
//        HomeScreen(click = click )
//    })
}

@Composable
fun ProductItem(item: ProductsItem, click:(Int) -> Unit)
{
    Card(elevation = 10.dp, modifier = Modifier
        .padding(8.dp)
        .clickable {
            click(item.id)
        }) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp)
        ) {
            DefaultIcon(icon = rememberAsyncImagePainter(model = item.image))
            // GymIcon(Icons.Filled.Place, Modifier.weight(0.15f))
            ProductDetails(item)
         //   ProductDetails(item, Modifier.weight(0.70f))
        }
//        Row(verticalAlignment = Alignment.CenterVertically,
//            modifier = Modifier.padding(8.dp)) {
//            DefaultIcon(icon = rememberAsyncImagePainter(model = item.image))
//            // GymIcon(Icons.Filled.Place, Modifier.weight(0.15f))
//            ProductDetails(item, Modifier.weight(0.70f))
//        }
    }
}

@Composable
fun DefaultIcon(
    icon: Painter
)
{
    Image(
        painter = icon,
        contentDescription = null,
        modifier = Modifier
            .padding(18.dp)
            .size(128.dp)
    )
}

@Composable
fun ProductDetails(item: ProductsItem, horizontalAlignment: Alignment.Horizontal = Alignment.Start,
showDescription:Boolean = false)
{
    Column(modifier = Modifier.padding(20.dp),horizontalAlignment = horizontalAlignment)
    {

        Text(text = item.title,
            style = MaterialTheme.typography.h6
            , color = Purple200, maxLines = 1, overflow = TextOverflow.Ellipsis)

        if(showDescription)
        {
            Text(text = item.description, color = Purple500)
        }
    }

}
@Composable
fun BottomNavigationCreate(
    items: List<BottomNavigationItem>,
    selectedIndex: Int,
    onSelectedIndexChanged: (Int) -> Unit,
    click: (Int) -> Unit
) {
    BottomNavigation(
        modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 16.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .height(56.dp),
        backgroundColor = colorResource(id = R.color.purple_500),
        elevation = 8.dp
    ) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = null) },
                label = { Text(text = item.label) },
                selected = selectedIndex == index,
                onClick = { onSelectedIndexChanged(index)
                          click(index)},
                alwaysShowLabel = false
            )
        }
    }
}