package com.dijonz.myreminder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TarefasAdapter(val tarefas: ArrayList<Tarefa>) :
    RecyclerView.Adapter<TarefasAdapter.TarefasViewHolder>() {

    class TarefasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.findViewById(R.id.tvVh_title)
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
        val tarefa = tarefas[position]
        holder.title.setText(tarefa.nome)
    }
}