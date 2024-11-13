package com.jk.btg.data.model.addresses

import java.util.Date

data class Address(
    val id: Int,
    val street1: String,
    val street2: String,
    val city: String,
    val state: String,
    val zipcode: String,
    val customer: Int,
    val nickname: String,
    val archived: Boolean,
    val createdAt: Date,
    val updatedAt: Date
) {
}