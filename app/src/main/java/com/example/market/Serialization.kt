package com.example.market

import android.content.Context
import android.widget.Toast
import com.example.market.model.Product
import com.google.gson.Gson
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.FileWriter
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

fun removeProductFromFavorites(context: Context, product: Product) {
    val file = File(context.filesDir, "favorites.dat")
    val favorites = loadFavoritesFromFile(context).toMutableList()
    favorites.remove(product)
    ObjectOutputStream(FileOutputStream(file)).use { outputStream ->
        outputStream.writeObject(favorites)
    }
}
fun saveProductToFavorites(context: Context, product: Product) {
    val file = File(context.filesDir, "favorites.dat")
    val favorites = loadFavoritesFromFile(context).toMutableList()

    favorites.add(product)

    ObjectOutputStream(FileOutputStream(file)).use { outputStream ->
        outputStream.writeObject(favorites)
    }
}
fun loadFavoritesFromFile(context: Context): List<Product> {
    val file = File(context.filesDir, "favorites.dat")
    if (!file.exists()) {
        return emptyList()
    }

    ObjectInputStream(FileInputStream(file)).use { inputStream ->
        val obj = inputStream.readObject()
        if (obj is List<*>) {
            @Suppress("UNCHECKED_CAST")
            return obj as List<Product>
        } else {
            throw IllegalArgumentException("Некорректный тип данных")
        }
    }
}
fun saveProductToPurchases(context: Context, product: Product) {
    val file = File(context.filesDir, "purchases.json")
    val purchases = loadPurchases(context)
    purchases.add(product)

    println("Saving product: $product")

    try {
        val json = Gson().toJson(purchases)
        FileWriter(file).use { writer ->
            writer.write(json)
        }
        println("Product saved successfully!")
    } catch (e: IOException) {
        e.printStackTrace()
        Toast.makeText(context, "Ошибка сохранения покупки", Toast.LENGTH_SHORT).show()
    }
}

fun loadPurchases(context: Context): MutableList<Product> {
    val file = File(context.filesDir, "purchases.json")
    if (!file.exists()) {
        return mutableListOf()
    }

    return try {
        val json = file.readText()
        val purchases = Gson().fromJson(json, Array<Product>::class.java).toMutableList()
        purchases
    } catch (e: Exception) {
        e.printStackTrace()
        Toast.makeText(context, "Ошибка загрузки покупок", Toast.LENGTH_SHORT).show()
        mutableListOf()
    }
}

fun addToPurchases(context: Context, product: Product) {
    val purchases = loadPurchases(context)
    purchases.add(product)
    saveProductToPurchases(context, purchases)
    removeProductFromFavorites(context, product)
}
fun saveProductToPurchases(context: Context, purchases: MutableList<Product>) {
    val file = File(context.filesDir, "purchases.json")
    try {
        val json = Gson().toJson(purchases)
        FileWriter(file).use { writer -> writer.write(json) }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}