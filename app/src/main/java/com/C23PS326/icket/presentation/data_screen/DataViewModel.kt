package com.C23PS326.icket.presentation.data_screen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.C23PS326.icket.screen.Provinsi
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class DataViewModel: ViewModel(){
    val state = mutableStateOf(Provinsi())

    init {
        getData()
    }

    private fun getData(){
        viewModelScope.launch {
            state.value = getDataFromFireStore()
        }
    }
}
suspend fun getDataFromFireStore():Provinsi{
    val db = FirebaseFirestore.getInstance()
    var bali = Provinsi()

    try {
        db.collection("provinsi").get().await().map {
           val result =  it.toObject(Provinsi::class.java)
            bali = result
        }
    }catch (e: FirebaseFirestoreException){
        Log.d("error", "getDataFromFireStore: $e")

    }
    return bali
}