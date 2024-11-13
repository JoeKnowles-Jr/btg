package com.jk.btg.data.model.users

import java.util.Date

data class User(
    val id: Int,
    val email: String,
    val password: String,
    val firstName :String,
    val lastName: String,
    val phone: String,
    val needsPwUpdate: Boolean,
    val address: Int,
    val role: String,
    val createdAt: Date,
    val updatedAt: Date
) {
}