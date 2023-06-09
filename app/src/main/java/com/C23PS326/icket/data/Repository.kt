package com.C23PS326.icket.data

import com.C23PS326.icket.model.OrderRekomendasi
import com.C23PS326.icket.model.RekomendasiData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class Repository {
    private val rekomen = mutableListOf<OrderRekomendasi>()

    init {
        if (rekomen.isEmpty()) {
            RekomendasiData.rekomendata.forEach{
                rekomen.add(OrderRekomendasi(it,0))
            }
        }
    }
    fun getRekomendasi(): Flow<MutableList<OrderRekomendasi>> {
        return flowOf(rekomen)
    }


    fun getOrderById(wisataId: Long): OrderRekomendasi {
        return rekomen.first() {
            it.rekomendasi.rekomenId == wisataId
        }
    }

}