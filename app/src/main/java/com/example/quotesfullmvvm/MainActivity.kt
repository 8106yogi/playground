package com.example.quotesfullmvvm

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.quotesfullmvvm.databinding.ActivityMainBinding
import com.example.quotesfullmvvm.model.BaseResponse.*
import com.example.quotesfullmvvm.model.Result
import com.example.quotesfullmvvm.recycler.MyRecyclerViewAdapter
import com.example.quotesfullmvvm.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel


    private lateinit var list: MutableList<Result>

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialization()
        initRecycler()


        mainViewModel.quotesResponse.observe(this) {
            when (it) {
                is LOADING -> {
                    Toast.makeText(applicationContext, "LOADING", Toast.LENGTH_SHORT).show()
                }
                is SUCCESS -> {
                    it.data?.let { it1 -> list.addAll(it1.results) }
                    Toast.makeText(applicationContext, "Success", Toast.LENGTH_SHORT).show()
                }
                is ERROR -> {
                    Toast.makeText(applicationContext, it.errorMessage, Toast.LENGTH_SHORT).show()
                }
            }
            activityMainBinding.recyclerView.adapter?.notifyDataSetChanged()
        }

    }

    private fun initialization() {
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainViewModel =
            ViewModelProvider(this)[MainViewModel::class.java]
        activityMainBinding.mainviewmodel = mainViewModel
        activityMainBinding.lifecycleOwner = this


    }

    private fun initRecycler() {
        list = mutableListOf()
        val adapter = MyRecyclerViewAdapter(list, R.layout.raw_quote_item, bindingInterface)
        activityMainBinding.recyclerView.adapter = adapter
    }

    private val bindingInterface =
        object : MyRecyclerViewAdapter.GenericRecyclerBindInterface<Result> {
            override fun bindData(item: Result, view: View) {
                val tvAuthor = view.findViewById<TextView>(R.id.tv_author)
                tvAuthor.text = item.author
                val tvQuotes = view.findViewById<TextView>(R.id.tv_quote)
                tvQuotes.text = item.content
            }
        }
}