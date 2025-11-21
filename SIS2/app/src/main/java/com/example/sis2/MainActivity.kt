package com.example.sis2

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val viewModel: NewsViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NewsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = NewsAdapter(mutableListOf()) {
            postId -> viewModel.toggleLike(postId)
        }
        recyclerView.adapter = adapter

        viewModel.posts.observe(this, Observer{
            posts -> adapter.submitList(posts)
        })
    }

}