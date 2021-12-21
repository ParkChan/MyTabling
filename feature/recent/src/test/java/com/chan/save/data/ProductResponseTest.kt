package com.chan.save.data

import com.chan.recent.data.ProductResponse
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ProductResponseTest {

    private val gson: Gson = GsonBuilder().setPrettyPrinting().create()

    @Test
    fun `ProductResponse Json 을 객체로 변환합니다`() {
        val productResponse = gson.fromJson(ITEM_JSON, ProductResponse::class.java) ?: ProductResponse()
        assertEquals(4797, productResponse.restaurantIdx)
        assertEquals("https://image.tabling.co.kr/prod/restaurant/44cddc5b6ab8289b680562ccb8d8cf63.jpg", productResponse.thumbnail)
        assertEquals("양식", productResponse.classification)
        assertEquals("303화덕 송정점", productResponse.restaurantName)
        assertEquals(4.7f, productResponse.rating)
        assertEquals(28, productResponse.reviewCount)
        assertEquals("송정동", productResponse.summaryAddress)
        assertEquals(false, productResponse.isQuickBooking)
        assertEquals(true, productResponse.isRemoteWaiting)
        assertEquals(true, productResponse.useWaiting)
        assertEquals(true, productResponse.useBooking)
        assertEquals(true, productResponse.isNew)
        assertEquals(0, productResponse.waitingCount)
    }

    companion object {
        private const val ITEM_JSON =
            """
                {
                    "restaurantIdx": 4797,
                    "thumbnail": "https://image.tabling.co.kr/prod/restaurant/44cddc5b6ab8289b680562ccb8d8cf63.jpg",
                    "classification": "양식",
                    "restaurantName": "303화덕 송정점",
                    "rating": 4.7,
                    "reviewCount": 28,
                    "summaryAddress": "송정동",
                    "isQuickBooking": false,
                    "isRemoteWaiting": true,
                    "useWaiting": true,
                    "useBooking": true,
                    "isNew": true,
                    "waitingCount": 0
                }
            """
    }
}