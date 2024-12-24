package com.example.digdofooddevlivery.data

data class OrderState(
    val amount: Int,
    val totalPrice: String,
)

val oderData = OrderState(
    amount = 5,
    totalPrice ="Rp.50.000")