package com.dijonz.myreminder.mainActivity

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.dijonz.myreminder.databinding.FragmentBBinding
import com.dijonz.myreminder.recyclerView.ListViewModel
import com.dijonz.myreminder.recyclerView.Tarefa

class FragmentB : Fragment() {

    private var _binding: FragmentBBinding? = null
    private val binding get() = _binding!!
    private val sharedViewModel: ListViewModel by activityViewModels()
    private val sharedPreferences: SharedPreferences = requireContext().getSharedPreferences("UserSharedPreferences",Context.MODE_PRIVATE)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val context: Context? = context?.applicationContext


        binding.btProsseguir.setOnClickListener {

            if (context != null) {
                if (binding.etTaskName.text!!.isNotEmpty() && binding.etTaskID.text!!.isNotEmpty()) {

                    val name = binding.etTaskName.text.toString()
                    val id = binding.etTaskID.text.toString().toInt()

                    val singleTask = Tarefa(id,name)

                    if (id != -1) {
                        sharedViewModel.tasklist.add(singleTask)
                        //CloudData(context, sharedViewModel.tasklist).uploadTaskList()

                        sharedPreferences.edit().putString("UserTaskList", sharedViewModel.jsonList).apply()
                        val direction = FragmentBDirections.actionFragmentBToFragmentA()
                        findNavController().navigate(direction)

                    }
                    else
                        makeToast("Utilize um id válido", context)
                } else
                    makeToast("Preencha todos os campos", context)
            }
        }
    }


    fun makeToast(text: String, context: Context) {
        val toast = Toast.makeText(context, text, Toast.LENGTH_LONG)
        toast.show()
    }


}