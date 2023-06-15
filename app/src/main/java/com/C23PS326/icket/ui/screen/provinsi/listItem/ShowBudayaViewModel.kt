package com.C23PS326.icket.ui.screen.provinsi.listItem

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.C23PS326.icket.data.Repository
import com.C23PS326.icket.model.budaya.OrderBudaya
import com.C23PS326.icket.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
class ShowBudayaViewModel(
    private val repository: Repository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<OrderBudaya>>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<OrderBudaya>>>
        get() = _uiState

    fun getBudaya() {
        viewModelScope.launch {
            repository.getAllBudaya()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { orderBudaya ->
                    _uiState.value = UiState.Success(orderBudaya)
                }
        }
    }
}