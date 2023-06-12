package com.C23PS326.icket.presentation.data_screen

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.C23PS326.icket.ui.screen.Provinsi
import com.C23PS326.icket.ui.theme.ICKETTheme
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.Source
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
suspend fun getDataFromFireStore(): Provinsi {
    val db = FirebaseFirestore.getInstance()
    var provinsi = Provinsi()
// Source can be CACHE, SERVER, or DEFAULT.
    val docRef = db.collection("provinsi").document("bali")
// Source can be CACHE, SERVER, or DEFAULT.
    val source = Source.CACHE
// Get the document, forcing the SDK to use the offline cache
    docRef.get(source).addOnCompleteListener { task ->
        if (task.isSuccessful) {
            // Document found in the offline cache
            val document = task.result
            Log.d(TAG, "Cached document data: ${document?.data}")
        } else {
            Log.d(TAG, "Cached get failed: ", task.exception)
        }
    }
    return provinsi
}

@Preview(showBackground = true)
@Composable
fun DataPreview() {
    ICKETTheme {
        DataViewModel()
    }
}