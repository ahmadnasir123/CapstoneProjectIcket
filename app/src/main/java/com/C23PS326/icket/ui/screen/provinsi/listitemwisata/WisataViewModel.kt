package com.C23PS326.icket.ui.screen.provinsi.listitemwisata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.C23PS326.icket.data.Repository
import com.C23PS326.icket.model.wisata.OrderWisata
import com.C23PS326.icket.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WisataViewModel(private val repository: Repository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<OrderWisata>> =
        MutableStateFlow(UiState.Loading)
    val uIState: StateFlow<UiState<OrderWisata>>
        get() = _uiState

    fun getWisata2(wisatId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getWisataById(wisatId))
        }
    }


}