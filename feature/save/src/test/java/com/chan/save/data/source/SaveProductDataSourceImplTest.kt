package com.chan.save.data.source

import com.chan.save.data.ProductsResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SaveProductDataSourceImplTest {

    private val tablingApi: TablingApi = mockk(relaxed = true)
    private lateinit var productDataSourceImpl: SaveProductDataSourceImpl

    @BeforeEach
    fun setup() {
        productDataSourceImpl = SaveProductDataSourceImpl(tablingApi)
    }

    @Test
    fun `상품 가져오기 DataSource 기능 테스트`() = runBlocking {
        val mockResponse: ProductsResponse = mockk(relaxed = true)

        coEvery {
            tablingApi.fetchProduct()
        } returns mockResponse

        val result = productDataSourceImpl.fetchProduct()

        assertEquals(mockResponse, result)
    }
}