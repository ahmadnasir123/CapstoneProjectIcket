package com.C23PS326.icket.ui.screen.provinsi.listItem

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.C23PS326.icket.data.Repository
import com.C23PS326.icket.model.OrderBudaya
import com.C23PS326.icket.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BudayaViewModel(private val repository: Repository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<OrderBudaya>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<OrderBudaya>> get() = _uiState

    fun getBudayaId(budayaId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getBudayaById(budayaId))
        }
    }
}