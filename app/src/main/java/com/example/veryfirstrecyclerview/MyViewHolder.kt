package com.example.veryfirstrecyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    val itemTextView = itemView.findViewById<TextView>(R.id.item)
}