package com.example.shopdanisms.entity

/**
 * Product as an Entity.
 *
 * An entity class to persist products in database.
 * @property id product's id.
 * @property name product's name.
 * @property description product's description.
 * @property company the company that produces the product.
 * @property purchasePrice product purchase price.
 * @property salePrice product sale price.
 * @property isPaid defines if the product is paid.
 * @property isSold defines if the product is sold.
 */
data class Product(
    val id: Long,
    val name: String,
    val description: String,
    val company: String,
    val purchasePrice: Float,
    val salePrice: Float,
    val isPaid: Boolean,
    val isSold: Boolean
)
