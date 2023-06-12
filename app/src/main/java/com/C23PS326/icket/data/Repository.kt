package com.C23PS326.icket.data

import com.C23PS326.icket.model.OrderRekomendasi
import com.C23PS326.icket.model.RekomendasiData
import com.C23PS326.icket.model.team.OrderTeam
import com.C23PS326.icket.model.team.TeamData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class Repository {
    private val rekomen = mutableListOf<OrderRekomendasi>()
    private val team = mutableListOf<OrderTeam>()

    init {
        if (rekomen.isEmpty()) {
            RekomendasiData.rekomendata.forEach{
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

}