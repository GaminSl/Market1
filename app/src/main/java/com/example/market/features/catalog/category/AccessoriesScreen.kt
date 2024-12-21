package com.example.market.features.catalog.category

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
fun AccessoriesScreen(navController: NavHostController) {
    val products = listOf(
        Product(
            name = "Часы с кожаным ремешком",
            price = 2499.99,
            description = "Элегантные часы с кожаным ремешком, подходят под любой стиль.",
            imageUrl1 = "https://img.joomcdn.net/1ae2ac9705f35c717ef92f0f7c9ad7ee19590b6c_original.jpeg",
            imageUrl2 = "https://img.joomcdn.net/134632365b17f9c2bdb3c6339a41874aae3f24e8_original.jpeg"
        ),
        Product(
            name = "Кожаный кошелек",
            price = 1499.99,
            description = "Стильный и практичный кошелек из натуральной кожи.",
            imageUrl1 = "https://avatars.mds.yandex.net/i?id=3903335484f5afd6bb8b13f7bcfbca591a357efb-10577272-images-thumbs&n=13",
            imageUrl2 = "https://sun9-35.userapi.com/impf/c851320/v851320132/4df56/YM0G0P-xN6o.jpg?size=604x401&quality=96&sign=68e0e96441e1192a85bc59399f67fe73&c_uniq_tag=_ZeH_L5wwopYfrUGdsjaqV-kW3aqXuSmjn9pzCeGo8Q&type=album"
        ),
        Product(
            name = "Солнечные очки",
            price = 1999.99,
            description = "Современные солнечные очки для защиты от ультрафиолета.",
            imageUrl1 = "https://cdn1.ozone.ru/s3/multimedia-j/6344800855.jpg",
            imageUrl2 = "https://avatars.mds.yandex.net/i?id=b3746e2f6e80fbf4104253c0a3769ca7_sr-8410613-images-thumbs&n=13"
        ),
        Product(
            name = "Ремень из натуральной кожи",
            price = 999.99,
            description = "Качественный ремень из натуральной кожи, идеально подходит для делового стиля.",
            imageUrl1 = "https://cdn1.ozone.ru/s3/multimedia-v/6181585363.jpg",
            imageUrl2 = "https://www.modernbag.ru/published/publicdata/MODERNBAGS/attachments/SC/products_pictures/BL-L-8203%20%282%29_enl.jpg"
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
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Назад",
                    tint = Color.Black
                )
            }

            Text(
                text = "Аксессуары",
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
