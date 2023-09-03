package com.ferchu.palabrasiguales

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ferchu.palabrasiguales.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {
    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CompareTextsEqual() = runTest {
        viewModel.compare("Hola", "Hola")
        val isEqual = viewModel.isEqual.value
        assertEquals(true, isEqual)
    }

    @Test
    fun mainViewModel_CompareTextsNotEqual() = runTest {
        viewModel.compare("Hola", "hola")
        val isEqual = viewModel.isEqual.value
        assertEquals(false, isEqual)
    }
}