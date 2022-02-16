package com.example.quotesfullmvvm.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class GenericRecyclerViewListAdapter<T : Any, VM : ViewDataBinding>(
    private val dataSet: List<T>,
    @LayoutRes val layoutId: Int, private val bindInterface: GenericRecyclerBindInterface<T, VM>
) :
    ListAdapter<T, GenericRecyclerViewListAdapter.MyViewHolder>(GenericDiffUtilCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            layoutId,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataSet[position], bindInterface)
    }

    class MyViewHolder(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun <T : Any, VM : ViewDataBinding> bind(
            item: T,
            bindingInterface: GenericRecyclerBindInterface<T, VM>
        ) = bindingInterface.bindData(item, binding as VM)
    }


    interface GenericRecyclerBindInterface<T, VM> {
        fun bindData(item: T, binding: VM)
    }


}


