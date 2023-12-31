package com.cenkeraydin.todoapp.Adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cenkeraydin.todoapp.databinding.ItemTodoBinding
import com.cenkeraydin.todoapp.model.Todo

class TodoAdapter(private val todoList:ArrayList<Todo>, private val listener:Listener): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    interface Listener{
        fun onItemClick(todoModel:Todo)
    }
    private val colors:Array<String> = arrayOf("#e86343","#f5dcd1","#ffa07a","#dec158","#e44803","#949587","#195765","#03363e")

    class TodoViewHolder(val binding:ItemTodoBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(todoModel: Todo,colors:Array<String>,position:Int, listener: Listener){
            itemView.setOnClickListener{
                listener.onItemClick(todoModel)
            }
            itemView.setBackgroundColor(Color.parseColor(colors[position % 8]))
            binding.tvTitle.text=todoModel.todo
            binding.cbDone.isChecked=todoModel.completed
        }
    }
    override fun getItemCount() =todoList.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(ItemTodoBinding.inflate( LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
       holder.bind(todoList[position],colors, position, listener)
        }
    }
}