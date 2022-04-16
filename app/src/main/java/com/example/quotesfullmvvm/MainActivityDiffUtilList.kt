package com.example.quotesfullmvvm

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.example.quotesfullmvvm.application.QuotesFullMVVMApplication
import com.example.quotesfullmvvm.databinding.ActivityMainBinding
import com.example.quotesfullmvvm.databinding.RawQuoteItemBinding
import com.example.quotesfullmvvm.factory.ViewModelFactory
import com.example.quotesfullmvvm.model.Result
import com.example.quotesfullmvvm.recycler.GenericRecyclerViewListAdapter
import com.example.quotesfullmvvm.viewmodel.MainViewModel
import javax.inject.Inject

class MainActivityDiffUtilList : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var list: MutableList<Result>

    @Inject
    lateinit var factory: ViewModelFactory

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialization()

        mainViewModel.quotesResponse.observe(this) {
            it.data?.let { it1 -> list.addAll(it1.results) }
            (activityMainBinding.recyclerView.adapter as GenericRecyclerViewListAdapter<Result, ViewDataBinding>).submitList(
                list
            )
//            (activityMainBinding.recyclerView.adapter as GenericRecyclerViewListAdapter<Result, ViewDataBinding>).submitList(
//                list.toMutableList()
//            )
        }

    }

    private fun initialization() {
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        (application as QuotesFullMVVMApplication).applicationComponent.inject(this)


        mainViewModel =
            ViewModelProvider(this, factory)[MainViewModel::class.java]


        activityMainBinding.mainviewmodel = mainViewModel
        activityMainBinding.lifecycleOwner = this
        activityMainBinding.recyclerView.setHasFixedSize(true)
        list = mutableListOf()
        val adapter =
            GenericRecyclerViewListAdapter(list, R.layout.raw_quote_item_, bindingInterface)
        activityMainBinding.recyclerView.adapter = adapter
    }


    private val bindingInterface =
        object :
            GenericRecyclerViewListAdapter.GenericRecyclerBindInterface<Result, RawQuoteItemBinding> {
            override fun bindData(item: Result, binding: RawQuoteItemBinding) {
                binding.tvAuthor.text = item.author
                binding.tvQuote.text = item.content
            }
        }

}