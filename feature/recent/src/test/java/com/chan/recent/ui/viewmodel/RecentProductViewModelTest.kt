package com.chan.recent.ui.viewmodel

import com.chan.recent.domain.Product
import com.chan.recent.domain.RecentProductUseCaseImpl
import com.chan.recent.ui.RecentProductViewModel
import com.chan.recent.ui.util.InstantExecutorExtension
import com.chan.recent.ui.util.getOrAwaitValue
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(InstantExecutorExtension::class)
class RecentProductViewModelTest {
    private val useCase: RecentProductUseCaseImpl = mockk(relaxed = true)
    private lateinit var viewModel: RecentProductViewModel

    @BeforeEach
    fun setUp() {
        viewModel = RecentProductViewModel(useCase)
    }

    @Test
    fun `최근본 리스트를 불러옵니다`() = runBlocking {

        val mockRes: List<Product> = emptyList()

        coEvery {
            useCase.fetchProduct().getOrNull()
        } returns mockRes

        viewModel.fetchProduct()

        assertEquals(
            mockRes,
            viewModel.products.getOrAwaitValue()
        )
    }
}