package com.chan.save.domain

data class Product(
    val restaurantIdx: Int = 0,
    val thumbnail: String = "",
    val classification: String = "",
    val restaurantName: String = "",
    val rating: Float = 0.0f,
    val reviewCount: Int = 0,
    val summaryAddress: String = "",
    val isQuickBooking: Boolean = false,
    val isRemoteWaiting: Boolean = false,
    val useWaiting: Boolean = false,
    val useBooking: Boolean = false,
    val isNew: Boolean = false,
    val waitingCount: Int = 0
)