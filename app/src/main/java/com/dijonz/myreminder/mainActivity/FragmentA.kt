package com.dijonz.myreminder.mainActivity

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.datastore.core.DataStore
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dijonz.myreminder.CloudData
import com.dijonz.myreminder.databinding.FragmentABinding
import com.dijonz.myreminder.recyclerView.ListViewModel
import com.dijonz.myreminder.recyclerView.Tarefa
import com.dijonz.myreminder.recyclerView.TarefasAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.remote.Datastore
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch
import java.util.ArrayList
import java.util.prefs.Preferences

class FragmentA : Fragment() {

    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!


    private lateinit var db: FirebaseFirestore
    private lateinit var auth: FirebaseAuth
    private lateinit var userUid: String

    private val sharedViewModel: ListViewModel by activityViewModels()

    //private val sharedPreferences: SharedPreferences = requireContext().getSharedPreferences("UserSharedPreferences",Context.MODE_PRIVATE)

    private var adapterList: ArrayList<Tarefa> = ArrayList<Tarefa>()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = Firebase.firestore
        auth = Firebase.auth
        userUid = auth.currentUser?.uid.toString()

        //sharedPreferences.edit().putString("UserTaskList", sharedViewModel.jsonList).apply()

        /*val jsonList = sharedPreferences.getString("UserTaskList", null)
        if (jsonList != null) {
            val gson = Gson()
            val list: ArrayList<Tarefa> =
                gson.fromJson(jsonList, object : TypeToken<ArrayList<Tarefa>>() {}.type)
            adapterList = list
        }*/


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(binding.root, savedInstanceState)

        val context: Context? = context


        //Referencias da lista de tarefas para o recyclerView
        val adapter = TarefasAdapter(adapterList)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        /*sharedViewModel.tasklist.observe(viewLifecycleOwner){ tasklist ->
            adapter.notifyDataSetChanged()
            if (context != null) {
                CloudData(context.applicationContext,sharedViewModel.tasklist).uploadTaskList()
            }
        }*/

        //Botão para adicionar tarefas
        binding.fabAdd.setOnClickListener {
            val direction = FragmentADirections.actionFragmentAToFragmentB()
            findNavController().navigate(direction)
        }

    }

    /*TODO: Elaborar um método para essa função ser chamada.
    fun removeFromList(position: Int) {
        val context = context?.applicationContext
        if (context != null){
            CloudData(context.applicationContext, sharedViewModel.tasklist).uploadTaskList()
            TarefasAdapter(sharedViewModel.taskList).notifyItemRemoved(position)
        }
    }*/

    /*
    private fun fetchList(){
        viewLifecycleOwner.lifecycleScope.launch {
            ListViewModel().fetchList()
        }
    }*/

}

