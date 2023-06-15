package com.C23PS326.icket.ui.screen.categori.wisata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.C23PS326.icket.data.Repository
import com.C23PS326.icket.model.categori.wisata.OrderWisataCategori
import com.C23PS326.icket.model.wisata.OrderWisata
import com.C23PS326.icket.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ShowWisataCategoriViewModel(
    private val repository: Repository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<OrderWisataCategori>>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<OrderWisataCategori>>>
        get() = _uiState

    fun getWisataCategori() {
        viewModelScope.launch {
            repository.getAllWisataCategori()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { orderWisataCategori ->
                    _uiState.value = UiState.Success(orderWisataCategori)
                }
        }
    }
}