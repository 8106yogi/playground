package com.example.quotesfullmvvm.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter<T : Any>(
    private val dataSet: List<T>,
    @LayoutRes val layoutId: Int, private val bindInterface: GenericRecyclerBindInterface<T>
) :
    RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun <T : Any> bind(
            item: T,
            bindingInterface: GenericRecyclerBindInterface<T>
        ) = bindingInterface.bindData(item, itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataSet[position], bindInterface)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    interface GenericRecyclerBindInterface<T> {
        fun bindData(item: T, view: View)
    }
}



