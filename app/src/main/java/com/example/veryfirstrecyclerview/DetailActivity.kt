package com.example.veryfirstrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    private lateinit var itemList: ItemList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val itemList = intent.getParcelableExtra(MainActivity.INTENT_LIST_KEY) as ItemList
        title = itemList.listName
    }
}
