package com.example.todolist

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_task)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnCreate = findViewById<FloatingActionButton>(R.id.btnCreate)

        btnCreate.setOnClickListener {
            val title = findViewById<EditText>(R.id.edTitle).text.toString()
            var description = findViewById<EditText>(R.id.edDescription).text.toString()

            if (description.isEmpty()) description = getString(R.string.no_text)

            if (title.isNotEmpty()) {
                val resultIntent = Intent()

                resultIntent.putExtra(Keys.TITLE_KEY, title)
                resultIntent.putExtra(Keys.DESCRIPTION_KEY, description)

                setResult(RESULT_OK, resultIntent)
                finish()
            } else {
                Toast.makeText(this, getString(R.string.empty_title), Toast.LENGTH_SHORT).show()
            }

        }
    }
}