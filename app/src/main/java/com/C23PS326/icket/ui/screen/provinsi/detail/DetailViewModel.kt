package com.C23PS326.icket.ui.screen.provinsi.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.C23PS326.icket.data.Repository
import com.C23PS326.icket.model.OrderRekomendasi
import com.C23PS326.icket.model.provinsi.OrderProvinsi
import com.C23PS326.icket.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: Repository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<OrderProvinsi>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<OrderProvinsi>> get() = _uiState

    fun getProvinsiId(provinsiId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getOrderByIdProvinsi(provinsiId))
        }
    }


}