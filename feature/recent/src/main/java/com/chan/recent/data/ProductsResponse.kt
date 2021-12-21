package com.chan.recent.data

import com.chan.recent.domain.Product
import com.google.gson.annotations.SerializedName

data class ProductsResponse(
    @SerializedName("list")
    val list: List<ProductResponse> = emptyList()
)

data class ProductResponse(
    @SerializedName("restaurantIdx")
    val restaurantIdx: Int = 0,

    @SerializedName("thumbnail")
    val thumbnail: String = "",

    @SerializedName("classification")
    val classification: String = "",

    @SerializedName("restaurantName")
    val restaurantName: String = "",

    @SerializedName("rating")
    val rating: Float = 0.0f,

    @SerializedName("reviewCount")
    val reviewCount: Int = 0,

    @SerializedName("summaryAddress")
    val summaryAddress: String = "",

    @SerializedName("isQuickBooking")
    val isQuickBooking: Boolean = false,

    @SerializedName("isRemoteWaiting")
    val isRemoteWaiting: Boolean = false,

    @SerializedName("useWaiting")
    val useWaiting: Boolean = false,

    @SerializedName("useBooking")
    val useBooking: Boolean = false,

    @SerializedName("isNew")
    val isNew: Boolean = false,

    @SerializedName("waitingCount")
    val waitingCount: Int = 0
) : MapToDomain<Product> {
    override fun mapToDomain(): Product = Product(
        restaurantIdx = restaurantIdx,
        thumbnail = thumbnail,
        classification = classification,
        restaurantName = restaurantName,
        rating = rating,
        reviewCount = reviewCount,
        summaryAddress = summaryAddress,
        isQuickBooking = isQuickBooking,
        isRemoteWaiting = isRemoteWaiting,
        useWaiting = useWaiting,
        useBooking = useBooking,
        isNew = isNew,
        waitingCount = waitingCount
    )

}