package com.C23PS326.icket.ui.screen.provinsi.listitemwisata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.C23PS326.icket.data.Repository
import com.C23PS326.icket.model.OrderBudaya
import com.C23PS326.icket.model.OrderWisata
import com.C23PS326.icket.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class WisataViewModel(private val repository: Repository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<OrderWisata>> =
        MutableStateFlow(UiState.Loading)
    val uIState: StateFlow<UiState<OrderWisata>>
        get() = _uiState

//    fun getWisata() {
//        viewModelScope.launch {
//            repository.getAllWisata()
//                .catch {
//                    _uiState.value = UiState.Error(it.message.toString())
//                }
//                .collect { orderWisata ->
//                    _uiState.value = UiState.Success(orderWisata)
//                }
//        }
//    }

    fun getWisata2(wisatId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getWisataById(wisatId))
        }
    }


}