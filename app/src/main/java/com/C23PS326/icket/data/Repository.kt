package com.C23PS326.icket.data

import com.C23PS326.icket.model.budaya.OrderBudaya
import com.C23PS326.icket.model.wisata.OrderWisata
import com.C23PS326.icket.model.budaya.RekomendasiDataBudaya
import com.C23PS326.icket.model.categori.wisata.CategoriDataWisata
import com.C23PS326.icket.model.categori.wisata.OrderWisataCategori
import com.C23PS326.icket.model.provinsi.DataProvinsi
import com.C23PS326.icket.model.provinsi.OrderProvinsi
import com.C23PS326.icket.model.wisata.RekomendasiDataWisata
import com.C23PS326.icket.model.team.OrderTeam
import com.C23PS326.icket.model.team.TeamData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class Repository {
    private val budaya = mutableListOf<OrderBudaya>()
    private val wisata = mutableListOf<OrderWisata>()
    private val team = mutableListOf<OrderTeam>()
    private val provinsi = mutableListOf<OrderProvinsi>()
    private val wisataCategori = mutableListOf<OrderWisataCategori>()

    init {
        if (budaya.isEmpty()) {
            RekomendasiDataBudaya.budayadata.forEach{
                budaya.add(OrderBudaya(it,0))
            }
        }

    }

    init {
        if (wisata.isEmpty()) {
            RekomendasiDataWisata.wisatadata.forEach{
                wisata.add(OrderWisata(it,0))
            }
        }
    }
    init {
        if (wisataCategori.isEmpty()) {
            CategoriDataWisata.wisatadatacategori.forEach{
                wisataCategori.add(OrderWisataCategori(it,0))
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

    fun getAllBudaya(): Flow<List<OrderBudaya>> {
        return flowOf(budaya)
    }
    fun getAllWisata(): Flow<List<OrderWisata>> {
        return flowOf(wisata)
    }
    fun getAllWisataCategori(): Flow<List<OrderWisataCategori>> {
        return flowOf(wisataCategori)
    }
    fun getOrderRewardById(budayaId: Long): OrderBudaya {
        return budaya.first {
            it.budaya.budayaId == budayaId
        }
    }


    init {
        if (team.isEmpty()) {
            TeamData.teamdata.forEach{
                team.add(OrderTeam(it,0))
            }
        }
    }

    fun getRekomendasi(): Flow<MutableList<OrderBudaya>> {
        return flowOf(budaya)
    }

    fun getWisata(): Flow<MutableList<OrderWisata>> {
        return flowOf(wisata)
    }

    fun getTeam(): Flow<MutableList<OrderTeam>> {
        return flowOf(team)
    }

    fun getOrderById(budayaId: Long): OrderBudaya {
        return budaya.first() {
            it.budaya.budayaId == budayaId
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

    fun getWisataCategori(): Flow<MutableList<OrderWisataCategori>> {
        return flowOf(wisataCategori)
    }

    fun getBudaya(): Flow<MutableList<OrderBudaya>> {
        return flowOf(budaya)
    }

    fun getOrderByIdProvinsi(provinsiId: Long): OrderProvinsi {
        return provinsi.first() {
            it.provinsi.provinsiId == provinsiId
        }
    }

    fun getBudayaById(budayaId: Long): OrderBudaya {
        return budaya.first() {
            it.budaya.budayaId == budayaId
        }
    }
    fun getWisataById(wisataId: Long): OrderWisata {
        return wisata.first() {
            it.wisata.wisataId == wisataId
        }
    }

    fun getWisataCategoryById(wisataCategoriId: Long): OrderWisataCategori {
        return wisataCategori.first() {
            it.wisatacategori.wisataId == wisataCategoriId
        }
    }



    companion object {
        @Volatile
        private var instance: Repository? = null


    }

}

