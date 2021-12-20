package com.chan.save.ui.viewmodel

import com.chan.save.domain.Product
import com.chan.save.domain.SaveProductUseCaseImpl
import com.chan.save.ui.SaveProductViewModel
import com.chan.save.ui.util.InstantExecutorExtension
import com.chan.save.ui.util.getOrAwaitValue
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(InstantExecutorExtension::class)
class SaveProductViewModelTest {
    private val useCase: SaveProductUseCaseImpl = mockk(relaxed = true)
    private lateinit var viewModel: SaveProductViewModel

    @BeforeEach
    fun setUp() {
        viewModel = SaveProductViewModel(useCase)
    }

    @Test
    fun `저장 리스트를 불러옵니다`() = runBlocking {

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