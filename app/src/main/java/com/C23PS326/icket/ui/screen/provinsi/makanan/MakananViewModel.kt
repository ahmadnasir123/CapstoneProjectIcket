package com.C23PS326.icket.ui.screen.provinsi.makanan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.C23PS326.icket.data.Repository
import com.C23PS326.icket.model.makanan.OrderMakanan
import com.C23PS326.icket.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch


class MakananViewModel (private val repository: Repository): ViewModel() {

    private val _uiState: MutableStateFlow<UiState<List<OrderMakanan>>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<OrderMakanan>>> get() = _uiState

    fun getMakanan() {
        viewModelScope.launch {
            repository.getMakanan()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { makanan ->
                    _uiState.value = UiState.Success(makanan)
                }
        }
    }
}