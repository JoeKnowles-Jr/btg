package com.jk.btg.data.model.customers

import java.util.Date

data class Customer(
    val id: Int,
    val company: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
    val color: String,
    val createdAt: Date,
    val updatedAt: Date
) {
}