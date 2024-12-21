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
fun ShoesScreen(navController: NavHostController) {
    val products = listOf(
        Product(
            name = "Кроссовки Nike",
            price = 5999.99,
            description = "Комфортные спортивные кроссовки для активных людей.",
            imageUrl1 = "https://екатеринбург.вокруге.рф/static/item/14.--20-luchshih-krossovok-dlya-bega-v-2024-godu-2.jpg",
            imageUrl2 = "https://skiline.ru/images/glideride.jpg"
        ),
        Product(
            name = "Туфли кожаные",
            price = 7999.99,
            description = "Элегантные кожаные туфли для деловых встреч и торжеств.",
            imageUrl1 = "https://avatars.mds.yandex.net/i?id=004fff8247bffb8c9d4b5dac42c04ff7_l-10240278-images-thumbs&n=13",
            imageUrl2 = "https://avatars.mds.yandex.net/i?id=c7aa361f2ba0e20ff04b70dd270b3d40313ddf1d30af0165-12693483-images-thumbs&n=13"
        ),
        Product(
            name = "Ботинки зимние",
            price = 8999.99,
            description = "Удобные зимние ботинки с утеплителем для холодной погоды.",
            imageUrl1 = "https://avatars.mds.yandex.net/i?id=db967186c7b116c04a60a68e5bf6f850_l-5644622-images-thumbs&n=13",
            imageUrl2 = "https://i.pinimg.com/originals/f5/11/49/f511490c276acb8dc8c4817fe87e0731.jpg"
        ),
        Product(
            name = "Сандалии летние",
            price = 2499.99,
            description = "Легкие летние сандалии для жаркой погоды.",
            imageUrl1 = "https://avatars.mds.yandex.net/i?id=2a00000179ed833faaf3367a098c12cda478-4843806-images-thumbs&n=13",
            imageUrl2 = "https://img.alicdn.com/imgextra/TB1LH2XgiOYBuNjSsD4L6TSkFXa"
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
                    imageVector =  Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Назад",
                    tint = Color.Black
                )
            }

            Text(
                text = "Обувь",
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
