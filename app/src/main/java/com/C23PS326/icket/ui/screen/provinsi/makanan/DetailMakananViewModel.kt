package com.C23PS326.icket.ui.screen.provinsi.makanan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.C23PS326.icket.data.Repository
import com.C23PS326.icket.model.makanan.OrderMakanan
import com.C23PS326.icket.model.provinsi.OrderProvinsi
import com.C23PS326.icket.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailMakananViewModel(private val repository: Repository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<OrderMakanan>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<OrderMakanan>> get() = _uiState

    fun getMakananId(makananId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getOrderMakananById(makananId))
        }
    }
}