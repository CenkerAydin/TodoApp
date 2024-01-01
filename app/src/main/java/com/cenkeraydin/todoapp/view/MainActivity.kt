package com.cenkeraydin.todoapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cenkeraydin.todoapp.Adapter.TodoAdapter
import com.cenkeraydin.todoapp.databinding.ActivityMainBinding
import com.cenkeraydin.todoapp.model.Todo
import com.cenkeraydin.todoapp.retrofit.RetrofitInstance
import com.cenkeraydin.todoapp.service.TodoAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.IOException

const val TAG= "MainActivity"
class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private var todos: ArrayList<Todo>? = null
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    setupRecyclerView()
    loadData()

    }

    private fun loadData(){
        val retrofit=RetrofitInstance.api.getTodos()
        retrofit.enqueue(object :Callback<List<Todo>>{
            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
                binding.progressBar.isVisible = false
                if (response.isSuccessful) {
                    val todos = response.body()
                    todos?.let {
                        todoAdapter.todos = it
                    } ?: Log.e(TAG, "Response body is null")
                } else {
                    Log.e(TAG, "Response not successful: ${response.errorBody()}")
                }
            }
            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
                binding.progressBar.isVisible = false
                Log.e(TAG, "Network error: ${t.message}", t)

            }
        })
    }
    private fun setupRecyclerView()=binding.rvTodos.apply {
        todoAdapter=TodoAdapter()
        adapter=todoAdapter
        layoutManager=LinearLayoutManager(this@MainActivity)
    }
}