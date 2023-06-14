package com.C23PS326.icket.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.C23PS326.icket.data.Repository
import com.C23PS326.icket.model.OrderRekomendasi
import com.C23PS326.icket.model.OrderWisata
import com.C23PS326.icket.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: Repository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<OrderRekomendasi>>> =
        MutableStateFlow(UiState.Loading)
    private val _uiStateWis: MutableStateFlow<UiState<List<OrderWisata>>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<OrderRekomendasi>>>
    get() = _uiState
    val UIstate: StateFlow<UiState<List<OrderWisata>>>
    get() = _uiStateWis

    fun getAllRewards() {
        viewModelScope.launch {
            repository.getAllRewards()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { orderRewards ->
                    _uiState.value = UiState.Success(orderRewards)
                }
        }
    }

    fun getWisata() {
        viewModelScope.launch {
            repository.getWisata()
                .catch {
                    _uiStateWis.value = UiState.Error(it.message.toString())
                }
                .collect { orderWisata ->
                    _uiStateWis.value = UiState.Success(orderWisata)
                }
        }
    }
}