package com.C23PS326.icket.data

import com.C23PS326.icket.model.OrderRekomendasi
import com.C23PS326.icket.model.budaya.RekomendasiDataBudaya
import com.C23PS326.icket.model.provinsi.DataProvinsi
import com.C23PS326.icket.model.provinsi.OrderProvinsi
import com.C23PS326.icket.model.wisata.RekomendasiDataWisata
import com.C23PS326.icket.model.team.OrderTeam
import com.C23PS326.icket.model.team.TeamData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class Repository {
    private val rekomen = mutableListOf<OrderRekomendasi>()
    private val team = mutableListOf<OrderTeam>()
    private val provinsi = mutableListOf<OrderProvinsi>()

    init {
        if (rekomen.isEmpty()) {
            RekomendasiDataBudaya.rekomendata.forEach{
                rekomen.add(OrderRekomendasi(it,0))
            }
        }
        if (rekomen.isEmpty()) {
            RekomendasiDataWisata.wisatadata.forEach{
                rekomen.add(OrderRekomendasi(it,0))
            }
        }
    }

    init {
        if (team.isEmpty()) {
            TeamData.teamdata.forEach{
                team.add(OrderTeam(it,0))
            }
        }
    }

    init {
        if (provinsi.isEmpty()) {
            DataProvinsi.dataprovinsi.forEach {
                provinsi.add(OrderProvinsi(it, 0))
            }
        }
    }

    fun getAllRewards(): Flow<List<OrderRekomendasi>> {
        return flowOf(rekomen)
    }
    fun getOrderRewardById(rewardId: Long): OrderRekomendasi {
        return rekomen.first {
            it.rekomendasi.rekomenId == rewardId
        }
    }

    fun getRekomendasi(): Flow<MutableList<OrderRekomendasi>> {
        return flowOf(rekomen)
    }

    fun getTeam(): Flow<MutableList<OrderTeam>> {
        return flowOf(team)
    }

    fun getOrderById(wisataId: Long): OrderRekomendasi {
        return rekomen.first() {
            it.rekomendasi.rekomenId == wisataId
        }
    }
    fun getInstance(): Repository =
        instance ?: synchronized(this) {
            Repository().apply {
                instance = this
            }
        }

    fun getProvinsi(): Flow<MutableList<OrderProvinsi>> {
        return flowOf(provinsi)
    }

    fun getOrderByIdProvinsi(provinsiId: Long): OrderProvinsi {
        return provinsi.first() {
            it.provinsi.provinsiId == provinsiId
        }
    }


    companion object {
        @Volatile
        private var instance: Repository? = null


    }

}