package com.dijonz.myreminder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.dijonz.myreminder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val mock = TarefasMock()
        binding.recyclerView.adapter = TarefasAdapter(mock.listaTarefas)

    }
}