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

//    private val newsList = mutableListOf<NewsCard>(
//        NewsCard("1","Trump tells Israel to stop bombing Gaza as Hamas agrees to release hostages","The US president says he believes Hamas is \"ready for a lasting peace\", as the group seeks further negotiations on his peace proposal.\n" +
//                "\n","https://ichef.bbci.co.uk/ace/standard/1024/cpsprodpb/953a/live/8bcc0610-a0a4-11f0-b741-177e3e2c2fc7.jpg.webp"),
//        NewsCard("2","Sanae Takaichi set to become Japan's first female prime minister","Takaichi is a long-time admirer of Margaret Thatcher, but many female voters do not see her as an advocate for progress.","https://ichef.bbci.co.uk/news/480/cpsprodpb/2978/live/3fbb1f10-a0e8-11f0-b741-177e3e2c2fc7.jpg.webp"),
//        NewsCard("3","Money paid but no ship: The around-the-world cruise that is yet to set sail","The BBC has been speaking to retirees who want the firm selling the cruise to stop advertising and refund their deposits.","https://ichef.bbci.co.uk/news/480/cpsprodpb/dcca/live/fa42b3a0-a018-11f0-b741-177e3e2c2fc7.jpg.webp"),
//        NewsCard("4","Sean 'Diddy' Combs sentenced to more than four years in prison","Combs apologised to his mother, children, and victims, specifically naming his two ex-girlfriends, Casandra Ventura and \"Jane\".","https://ichef.bbci.co.uk/news/480/cpsprodpb/bd6e/live/fc8e9cd0-a083-11f0-bb47-b30225268691.jpg.webp"),
//        NewsCard("5","'Machines don't see gender': India's first female train driver on blazing the trail","Surekha Yadav became a train driver at a time when it was uncommon for Indian women to take up the profession.","https://ichef.bbci.co.uk/news/480/cpsprodpb/c63b/live/b1b41ac0-a04a-11f0-9251-31c97a45eb73.jpg.webp")
//    )

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