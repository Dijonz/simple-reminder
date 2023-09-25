package com.dijonz.myreminder.recyclerView
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson

class ListViewModel : ViewModel() {

    private val db = Firebase.firestore
    private val auth = Firebase.auth
    private val userUid = auth.currentUser?.uid.toString()

    val gson = Gson()


    //private val _tasklist = MutableLiveData<ArrayList<Tarefa>>()
    val tasklist: ArrayList<Tarefa> = ArrayList()
    val jsonList = gson.toJson(tasklist)



    /*
    suspend fun fetchList(): LiveData<ArrayList<Tarefa>> = withContext(Dispatchers.IO) {
        val snapshot = db.collection("users").document(userUid).get()
            .await()
        var genericList = ArrayList<Tarefa>()
        val datas = snapshot.data?.toMap()
        datas?.values?.forEach { tarefaData ->
            if (tarefaData is Map<*, *>) {
                val id = (tarefaData["id"] as Long).toInt()
                val name = tarefaData["nome"] as String
                val task = Tarefa(id, name)

                genericList.add(task)
            }

        }
        _tasklist.value = genericList

        return@withContext _tasklist
    }*/

    fun removeFromList(position: Int) {
        tasklist.removeAt(position)
    }


}