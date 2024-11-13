package com.jk.btg.data.model.deliveries

import java.util.Date

data class DeliveryDto(
    val id: Int,
    val date: Date,
    val customer: Int,
    val address: Int,
    val notes: String,
    val status: String,
    val createdAt: Date,
    val updatedAt: Date,
    val company: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
    val color: String,
    val street1: String,
    val street2: String,
    val city: String,
    val state: String,
    val zipcode: String,
    val nickname: String,
)
