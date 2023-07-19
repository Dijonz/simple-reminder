package com.dijonz.myreminder

class TarefasMock {
    var listaTarefas = ArrayList<Tarefa>()

    init{
        listaTarefas.add(Tarefa(1,"andar de bicicleta"))
        listaTarefas.add(Tarefa(2,"comprar abacate"))
        listaTarefas.add(Tarefa(3,"Fazer mercado"))
        listaTarefas.add(Tarefa(4,"ver videos do carlinho"))
    }
}