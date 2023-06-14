package com.C23PS326.icket.ui.screen.home

import com.C23PS326.icket.model.OrderRekomendasi
import com.C23PS326.icket.model.OrderWisata
import com.google.firestore.v1.StructuredQuery


    fun List<StructuredQuery.Order>.splitOrderData(): Pair<List<OrderRekomendasi>, List<OrderWisata>> {
        val orderRekomendasi = filterIsInstance<OrderRekomendasi>()
        val orderWisata = filterIsInstance<OrderWisata>()
        return Pair(orderRekomendasi, orderWisata)
    }
