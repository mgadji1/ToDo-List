package com.example.todolist

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = TaskAdapter(layoutInflater)
        recyclerView.adapter = adapter

        val btnAdd = findViewById<FloatingActionButton>(R.id.btnAdd)

        val addTaskLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                val title = data?.getStringExtra(Keys.TITLE_KEY).orEmpty()
                val description = data?.getStringExtra(Keys.DESCRIPTION_KEY).orEmpty()

                val task = Task(title, description)

                adapter.addTask(task)
            }
        }

        btnAdd.setOnClickListener {
            val intent = Intent(this, TaskActivity::class.java)
            addTaskLauncher.launch(intent)
        }
    }
}