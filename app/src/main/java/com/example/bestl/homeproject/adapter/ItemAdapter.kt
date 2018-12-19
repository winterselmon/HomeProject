package com.example.bestl.homeproject.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.bestl.homeproject.R
import java.util.*

class ItemAdapter(private val item_list: ArrayList<String>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView.rootView) {

        var tvItem: TextView = itemView.findViewById(R.id.text)

        fun bind(position: Int) {
            tvItem.text = item_list[position]
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val binding = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_adapter, viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind(i)
    }

    override fun getItemCount(): Int {
        return item_list.size
    }

}
