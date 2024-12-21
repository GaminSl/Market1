package com.example.market.features.main
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Shop
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.TextStyle
import com.example.market.model.customFont


@Composable
fun MainScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFAFAFA))
    ) {
        Column(
            modifier = Modifier
                .weight(7f)
                .fillMaxWidth()
                .background(color = Color.White)
                .padding(horizontal = 20.dp, vertical = 40.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Market ' Hueta '",
                style = TextStyle(
                    fontFamily = customFont,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF000000)
                )
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Мода для каждого дня",
                style = TextStyle(
                    fontFamily = customFont,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF7F8C8D)
                )
            )
        }

        Row(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .height(100.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavigationIconButton(
                icon = Icons.Filled.Shop,
                contentDescription = "Каталог",
                onClick = { navController.navigate("catalog_screen") }
            )
            NavigationIconButton(
                icon = Icons.Filled.Favorite,
                contentDescription = "Избранное",
                onClick = { navController.navigate("favorites_screen") }
            )
            NavigationIconButton(
                icon = Icons.Filled.ShoppingCart,
                contentDescription = "Покупки",
                onClick = { navController.navigate("purchases_screen") }
            )
            NavigationIconButton(
                icon = Icons.Filled.AccountCircle,
                contentDescription = "Аккаунт",
                onClick = { navController.navigate("account_screen") }
            )
        }
    }
}
