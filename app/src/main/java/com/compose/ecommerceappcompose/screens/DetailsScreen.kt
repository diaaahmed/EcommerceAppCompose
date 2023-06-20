package com.compose.ecommerceappcompose.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.compose.ecommerceappcompose.viewmodel.DetailsViewModel

@Composable
fun DetailsScreen()
{
    val detailsViewModel: DetailsViewModel = hiltViewModel()

    val item = detailsViewModel.state.value
    val context = LocalContext.current

    item?.let {product->
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            DefaultIcon(icon = rememberAsyncImagePainter(model = product.image))
            ProductDetails(item = product,
                horizontalAlignment = Alignment.CenterHorizontally,showDescription = true)
            Button(onClick = {

                Toast.makeText(context, "Button clicked", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Add to cart")
            }
        }
    }
}