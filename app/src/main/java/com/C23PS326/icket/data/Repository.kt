package com.C23PS326.icket.data

import com.C23PS326.icket.model.OrderRekomendasi
import com.C23PS326.icket.model.OrderWisata
import com.C23PS326.icket.model.budaya.RekomendasiDataBudaya
import com.C23PS326.icket.model.wisata.RekomendasiDataWisata
import com.C23PS326.icket.model.team.OrderTeam
import com.C23PS326.icket.model.team.TeamData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class Repository {
    private val rekomen = mutableListOf<OrderRekomendasi>()
    private val wisatan = mutableListOf<OrderWisata>()
    private val team = mutableListOf<OrderTeam>()

    init {
        if (rekomen.isEmpty()) {
            RekomendasiDataBudaya.rekomendata.forEach{
                rekomen.add(OrderRekomendasi(it,0))
            }
        }

    }

    init {
        if (wisatan.isEmpty()) {
            RekomendasiDataWisata.wisatadata.forEach{
                wisatan.add(OrderWisata(it,0))
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


    init {
        if (team.isEmpty()) {
            TeamData.teamdata.forEach{
                team.add(OrderTeam(it,0))
            }
        }
    }

    fun getRekomendasi(): Flow<MutableList<OrderRekomendasi>> {
        return flowOf(rekomen)
    }

    fun getWisata(): Flow<MutableList<OrderWisata>> {
        return flowOf(wisatan)
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
    companion object {
        @Volatile
        private var instance: Repository? = null


    }

}

