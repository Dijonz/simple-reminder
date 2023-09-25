package com.dijonz.myreminder.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.dijonz.myreminder.R
import java.util.ArrayList

class TarefasAdapter(val tarefas: ArrayList<Tarefa>) :
    RecyclerView.Adapter<TarefasAdapter.TarefasViewHolder>() {


    class TarefasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tvVh_title)
        val deleteBtn: ImageView = itemView.findViewById(R.id.ivVh_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefasViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.main_line_view, parent, false)
        return TarefasViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tarefas.size
    }

    override fun onBindViewHolder(holder: TarefasViewHolder, position: Int) {
        val tarefa = tarefas.get(position)
        holder.title.text = tarefa.nome
        holder.deleteBtn.setOnClickListener {
            tarefas.removeAt(position)
            notifyItemRemoved(position)
        }
    }

}