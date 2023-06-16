package com.C23PS326.icket.data

import com.C23PS326.icket.model.budaya.OrderBudaya
import com.C23PS326.icket.model.budaya.RekomendasiDataBudaya
import com.C23PS326.icket.model.categori.wisata.OrderWisataCategori
import com.C23PS326.icket.model.makanan.DataMakanan
import com.C23PS326.icket.model.makanan.OrderMakanan
import com.C23PS326.icket.model.provinsi.DataProvinsi
import com.C23PS326.icket.model.provinsi.OrderProvinsi
import com.C23PS326.icket.model.wisata.RekomendasiDataWisata
import com.C23PS326.icket.model.team.OrderTeam
import com.C23PS326.icket.model.team.TeamData
import com.C23PS326.icket.model.wisata.OrderWisata
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class Repository {
    private val budaya = mutableListOf<OrderBudaya>()
    private val wisata = mutableListOf<OrderWisata>()
    private val team = mutableListOf<OrderTeam>()
    private val provinsi = mutableListOf<OrderProvinsi>()
    private val makanan = mutableListOf<OrderMakanan>()
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

    init {
        if (makanan.isEmpty()) {
            DataMakanan.datamakanan.forEach {
                makanan.add(OrderMakanan(it, 0))
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


    init {
        if (team.isEmpty()) {
            TeamData.teamdata.forEach{
                team.add(OrderTeam(it,0))
            }
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

    fun getWisataCategori(): Flow<MutableList<OrderWisataCategori>> {
        return flowOf(wisataCategori)
    }

    fun getMakanan(): Flow<MutableList<OrderMakanan>> {
        return flowOf(makanan)
    }

    fun getOrderMakananById(makananId: Long): OrderMakanan {
        return makanan.first() {
            it.makanan.makananId == makananId
        }
    }


    companion object {
        @Volatile
        private var instance: Repository? = null


    }

}
