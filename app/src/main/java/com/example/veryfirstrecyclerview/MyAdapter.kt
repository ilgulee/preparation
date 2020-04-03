package com.example.veryfirstrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {
    private val myList = listOf("My task1", "My task2", "My task3", "My task3", "My task4")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_view_holder, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemTextView.text = myList[position]
    }
}