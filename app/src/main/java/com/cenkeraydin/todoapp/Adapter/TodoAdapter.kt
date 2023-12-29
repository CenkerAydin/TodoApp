package com.cenkeraydin.todoapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.cenkeraydin.todoapp.databinding.ItemTodoBinding
import com.cenkeraydin.todoapp.model.Todo

class TodoAdapter(private val todosList:ArrayList<Todo>): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(val binding:ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount() =todosList.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(ItemTodoBinding.inflate( LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binding.apply {
            val todo=todosList[position]
            tvTitle.text=todo.todo
            cbDone.isChecked=todo.completed

        }
    }
}