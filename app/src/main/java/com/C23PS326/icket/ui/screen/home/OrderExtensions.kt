package com.C23PS326.icket.ui.screen.home

import com.C23PS326.icket.model.OrderBudaya
import com.C23PS326.icket.model.OrderWisata
import com.google.firestore.v1.StructuredQuery


    fun List<StructuredQuery.Order>.splitOrderData(): Pair<List<OrderBudaya>, List<OrderWisata>> {
        val orderRekomendasi = filterIsInstance<OrderBudaya>()
        val orderWisata = filterIsInstance<OrderWisata>()
        return Pair(orderRekomendasi, orderWisata)
    }
