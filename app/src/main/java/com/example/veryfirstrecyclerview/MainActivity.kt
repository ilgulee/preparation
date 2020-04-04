package com.example.veryfirstrecyclerview

import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private val dataManager: ItemListDataManager by lazy {
        ItemListDataManager(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = dataManager.getItemList()
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(list)

        fab.setOnClickListener {
            showDialog()
        }

    }

    private fun showDialog() {
        val title = "Enter new task"
        val positiveButton = "Add"
        val dialog = AlertDialog.Builder(this)
        val editText = EditText(this)
        editText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_WORDS
        dialog
            .setTitle(title)
            .setView(editText)
            .setPositiveButton(positiveButton) { dialog, _ ->
                val adapter = recyclerView.adapter as MyAdapter
                val list = ItemList(editText.text.toString())
                dataManager.saveItemList(list)
                adapter.addList(list)
                dialog.dismiss()
            }
            .create()
            .show()
    }
}
