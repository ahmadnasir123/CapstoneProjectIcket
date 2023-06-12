package com.C23PS326.icket.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.C23PS326.icket.data.Repository
import com.C23PS326.icket.ui.screen.detail.DetailViewModel
import com.C23PS326.icket.ui.screen.home.HomeViewModel

class ViewModelFactory(private val repository: Repository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}