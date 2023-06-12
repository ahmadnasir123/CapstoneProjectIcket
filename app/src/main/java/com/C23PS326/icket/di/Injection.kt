package com.C23PS326.icket.di

import com.C23PS326.icket.data.Repository

object Injection {
    fun provideRepository(): Repository {
        return Repository().getInstance()
    }
}