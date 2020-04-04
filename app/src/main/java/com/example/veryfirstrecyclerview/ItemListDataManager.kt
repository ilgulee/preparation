package com.example.veryfirstrecyclerview

import android.content.Context
import androidx.preference.PreferenceManager


class ItemListDataManager(private val context: Context) {

    fun saveItemList(itemList: ItemList) {
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context).edit()
        sharedPrefs.putStringSet(itemList.listName, itemList.items.toHashSet())
        sharedPrefs.commit()
    }

    fun getItemList(): ArrayList<ItemList> {
        val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context)
        val contents = sharedPrefs.all
        val itemList = ArrayList<ItemList>()

        for (list in contents) {
            val items = ArrayList(list.value as HashSet<String>)
            val list = ItemList(list.key, items)
            itemList.add(list)
        }
        return itemList
    }
}