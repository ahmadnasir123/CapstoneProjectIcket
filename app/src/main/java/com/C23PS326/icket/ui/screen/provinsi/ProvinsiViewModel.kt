package com.C23PS326.icket.ui.screen.provinsi

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.C23PS326.icket.data.Repository
import com.C23PS326.icket.model.OrderRekomendasi
import com.C23PS326.icket.model.provinsi.OrderProvinsi
import com.C23PS326.icket.ui.common.UiState
import com.C23PS326.icket.ui.components.ProvinsiListItem
import com.C23PS326.icket.ui.components.ScrollToTopButton
import com.google.firestore.v1.StructuredQuery.Order
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
