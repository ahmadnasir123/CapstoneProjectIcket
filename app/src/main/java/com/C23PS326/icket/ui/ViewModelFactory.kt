package com.C23PS326.icket.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.C23PS326.icket.data.Repository
import com.C23PS326.icket.ui.screen.categori.wisata.CategoriWisataViewModel
import com.C23PS326.icket.ui.screen.categori.wisata.ShowWisataCategoriViewModel
import com.C23PS326.icket.ui.screen.provinsi.detail.DetailViewModel
import com.C23PS326.icket.ui.screen.provinsi.listItem.ShowBudayaViewModel
import com.C23PS326.icket.ui.screen.provinsi.listitemwisata.ShowWisataViewModel
import com.C23PS326.icket.ui.screen.provinsi.ProvinsiViewModel
import com.C23PS326.icket.ui.screen.provinsi.listItem.BudayaViewModel
import com.C23PS326.icket.ui.screen.provinsi.listitemwisata.WisataViewModel
import com.C23PS326.icket.ui.screen.provinsi.makanan.DetailMakananViewModel
import com.C23PS326.icket.ui.screen.provinsi.makanan.MakananViewModel

class ViewModelFactory(private val repository: Repository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShowBudayaViewModel::class.java)) {
            return ShowBudayaViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(BudayaViewModel::class.java)) {
            return BudayaViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(BudayaViewModel::class.java)) {
            return BudayaViewModel(repository) as T
        }

        if (modelClass.isAssignableFrom(ProvinsiViewModel::class.java)) {
            return ProvinsiViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(repository) as T
        }

        if (modelClass.isAssignableFrom(MakananViewModel::class.java)) {
            return MakananViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailMakananViewModel::class.java)) {
            return DetailMakananViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailMakananViewModel(repository) as T
        }

        if (modelClass.isAssignableFrom(ShowWisataViewModel::class.java)) {
            return ShowWisataViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(WisataViewModel::class.java)) {
            return WisataViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(WisataViewModel::class.java)) {
            return WisataViewModel(repository) as T
        }

        if (modelClass.isAssignableFrom(ShowWisataCategoriViewModel::class.java)) {
            return ShowWisataCategoriViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(CategoriWisataViewModel::class.java)) {
            return CategoriWisataViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(CategoriWisataViewModel::class.java)) {
            return CategoriWisataViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}