package com.jk.btg.data.model.deliveries

import java.util.Date

data class Delivery(
    val id: Int,
    val date: Date,
    val customer: Int,
    val address: Int,
    val notes: String,
    val status: String
    ) {
}