package com.C23PS326.icket.ui.screen.provinsi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.C23PS326.icket.data.Repository
import com.C23PS326.icket.model.provinsi.OrderProvinsi
import com.C23PS326.icket.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ProvinsiViewModel (private val repository: Repository): ViewModel() {

    private val _uiState: MutableStateFlow<UiState<List<OrderProvinsi>>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<OrderProvinsi>>> get() = _uiState

    fun getProvinsi() {
        viewModelScope.launch {
            repository.getProvinsi()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { provinsi ->
                    _uiState.value = UiState.Success(provinsi)
                }
        }
    }
}
