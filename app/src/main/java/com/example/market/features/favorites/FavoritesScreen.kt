package com.example.market.features.favorites

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.market.addToPurchases
import com.example.market.loadFavoritesFromFile

import com.example.market.model.Product

import com.example.market.model.product.ProductImage
import com.example.market.removeProductFromFavorites

@Composable
fun FavoritesScreen(navController: NavHostController) {
    val context = LocalContext.current
    val favorites = loadFavoritesFromFile(context).toMutableList()
    var showDialog by remember { mutableStateOf(false) }
    var productToDelete by remember { mutableStateOf<Product?>(null) }

    fun onLongPress(product: Product) {
        productToDelete = product
        showDialog = true
    }

    if (showDialog && productToDelete != null) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(text = "Удалить товар?") },
            text = { Text(text = "Вы уверены, что хотите удалить товар ${productToDelete?.name}?") },
            confirmButton = {
                TextButton(onClick = {
                    productToDelete?.let {
                        removeProductFromFavorites(context, it)
                        showDialog = false
                    }
                }) {
                    Text("Удалить")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Отмена")
                }
            }
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
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
                text = "Избранное",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                ),
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)
            )
        }
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 60.dp)
            .fillMaxSize()
            .padding(16.dp)

    ) {
        itemsIndexed(favorites) { index, product ->
            Box(
                modifier = Modifier
                    .background(
                        color = Color(0xFFE3F9F2),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .border(
                        width = 2.dp,
                        color = Color(0xFF4CAF50),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(bottom = 16.dp)
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .pointerInput(Unit) {
                        detectTapGestures(onLongPress = { onLongPress(product) })
                    }
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "${index + 1}. ${product.name} - ${product.price}₽",
                        modifier = Modifier
                            .padding(bottom = 12.dp)
                            .fillMaxWidth(),
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {

                        ProductImage(imageUrl = product.imageUrl1)

                        ProductImage(imageUrl = product.imageUrl2)
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Button(
                        onClick = {
                            addToPurchases(context, product)
                            favorites.removeAt(index)
                            Toast.makeText(
                                context,
                                "Товар добавлен в корзину",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(vertical = 8.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .shadow(8.dp, shape = RoundedCornerShape(12.dp)),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White,
                            containerColor = Color(0xFF4CAF50)
                        )
                    ) {
                        Text("Купить", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    }
                }

            }
            if (index < favorites.size - 1) {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}





