package com.example.todolist

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskViewHolder(private val containerView : View) : RecyclerView.ViewHolder(containerView) {
    val title = containerView.findViewById<TextView>(R.id.edTitle)
    val description = containerView.findViewById<TextView>(R.id.edDescription)
}