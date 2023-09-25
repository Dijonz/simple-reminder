package com.dijonz.myreminder

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import com.dijonz.myreminder.recyclerView.Tarefa
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CloudData(private val context: Context, private val taskList: LiveData<ArrayList<Tarefa>>) {


    //Firebase
    private var db = Firebase.firestore
    private var auth = Firebase.auth
    private val userUid = auth.currentUser?.uid.toString()

    //Lista atual
    private val list = taskList

    //Mapa vazio para comparação
    private val map = mutableMapOf<String, Tarefa>()


    fun uploadTaskList() {

        taskList.value?.let { list ->
            for (item in list) {
                map[item.nome] = item
            }
        }
        if (taskList.value?.isNotEmpty() == true) {
            Log.d("MAPA", "$map")
            db.collection("users").document(userUid)
                .update(map as Map<String, Tarefa>)
                .addOnSuccessListener {
                    Toast.makeText(context, "Lista Atualizada", Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener {
                    Toast.makeText(
                        context,
                        "Ocorreu um erro, verifique sua conexão",
                        Toast.LENGTH_LONG
                    ).show()
                }
        }
    }

    fun uploadTask(task: Tarefa) {
    }

}

