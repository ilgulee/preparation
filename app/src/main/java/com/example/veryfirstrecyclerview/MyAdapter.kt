package com.example.veryfirstrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val itemList: ArrayList<ItemList>) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_view_holder, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemTextView.text = itemList[position].listName
    }

    fun addList(list: ItemList) {
        itemList.add(list)
        //notifyDataSetChanged()
        notifyItemInserted(itemList.size - 1)
    }
}