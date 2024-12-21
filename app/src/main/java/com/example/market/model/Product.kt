package com.example.market.model

import java.io.Serializable

data class Product(
    val name: String,
    val price: Double,
    val description: String,
    val imageUrl1: String,
    val imageUrl2: String
) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Product) return false
        return name == other.name && price == other.price
    }

    override fun hashCode(): Int {
        return 31 * name.hashCode() + price.hashCode()
    }
}
