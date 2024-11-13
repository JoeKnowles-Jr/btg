package com.jk.btg.data.model.products

data class Box(
    val l: Float,
    val w: Float,
    val h: Float,
    val bundle: Int,
    val sku: String,
    val cost: Double,
    val priceRetail: Double,
    val priceBundle: Double,
    val price100: Double,
    val price250: Double,
    val price500: Double,
    val flatL: Float,
    val flatW: Float,
    val flatH: Float,
    val folds: Boolean = false,
    val foldedL: Float = 0.0f,
    val foldedW: Float = 0.0f,
    val foldedH: Float = 0.0f,
    val weight: Double,
    val stockCapacity: Int,
    val stockTrigger: Int,
    val inStock: Int,
    val vendor: String
) {
}