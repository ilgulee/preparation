package com.example.veryfirstrecyclerview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemList(val listName: String, val items: ArrayList<String> = ArrayList()) : Parcelable