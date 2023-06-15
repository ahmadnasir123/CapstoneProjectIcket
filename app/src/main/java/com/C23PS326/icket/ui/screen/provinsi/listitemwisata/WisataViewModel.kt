package com.C23PS326.icket.ui.screen.provinsi.listitemwisata

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
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
    val uiState2: StateFlow<UiState<OrderWisata>>
        get() = _uiState
    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun getWisata2(wisatId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getWisataById(wisatId))
        }
    }


    fun search(newQuery: String) {
        _query.value = newQuery
//        _groupedHeroes.value = repository.searchItem(_query.value)
//            .sortedBy { it.name }
//            .groupBy { it.name[0] }
    }


}