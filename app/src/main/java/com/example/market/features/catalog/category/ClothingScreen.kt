package com.example.market.features.catalog.category
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.market.model.Product
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.market.model.product.ProductCard


@Composable
fun ClothingScreen(navController: NavHostController) {
    val products = listOf(
        Product(
            name = "Кожаная куртка",
            price = 4999.99,
            description = "Стильная кожаная куртка для холодной погоды.",
            imageUrl1 = "https://avatars.mds.yandex.net/i?id=84915e91697235ce8a1afbd2b7883bb55be33880-11801546-images-thumbs&n=13",
            imageUrl2 = "https://ladyneeds.ru/wp-content/uploads/2021/04/kurtki-osen.jpg"
        ),
        Product(
            name = "Теплый свитер",
            price = 2999.99,
            description = "Мягкий и уютный свитер, идеален для зимних прогулок.",
            imageUrl1 = "https://i.pinimg.com/736x/3e/8a/8f/3e8a8f4af2feb212c2cd73cbaacb9e42.jpg",
            imageUrl2 = "https://i.pinimg.com/originals/33/85/d3/3385d3901419f3f2a012e5b59e8ccd6f.jpg"
        ),
        Product(
            name = "Джинсы slim-fit",
            price = 2499.99,
            description = "Удобные джинсы с хорошей посадкой, подходят для повседневной носки.",
            imageUrl1 = "https://oreol.com/img/men/10079_1.jpg",
            imageUrl2 = "https://static24.tgcnt.ru/posts/_0/12/1201c02ad1610b63070c941fa203733a.jpg"
        ),
        Product(
            name = "Парка зимняя",
            price = 5999.99,
            description = "Теплая парка для зимних прогулок, защищает от холода и ветра.",
            imageUrl1 = "https://i.pinimg.com/736x/fc/39/3e/fc393e4ca73088b3d8a9ae8e947f4dc0.jpg",
            imageUrl2 = "https://vpinfo.ru/images/products/4974/4f5623260e1000.jpg"
        )
    )
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Назад",
                    tint = Color.Black
                )
            }

            Text(
                text = "Одежда",
                style = TextStyle(
                    fontSize = 24.sp,
                    color = Color.Black
                ),
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)
            )
        }
        LazyColumn {
            items(products) { product ->
                ProductCard(product = product)
            }
        }
    }
}





