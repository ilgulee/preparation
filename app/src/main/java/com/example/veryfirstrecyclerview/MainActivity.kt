package com.example.veryfirstrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter()

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
                adapter.addItem(editText.text.toString())
                dialog.dismiss()
            }
            .create()
            .show()
    }
}
