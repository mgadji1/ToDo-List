package com.example.todolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(
    private val layoutInflater: LayoutInflater
) : RecyclerView.Adapter<TaskViewHolder>() {
    private val tasks = mutableListOf<Task>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TaskViewHolder {
        val view = layoutInflater.inflate(R.layout.task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: TaskViewHolder,
        position: Int
    ) {
        val task = tasks[position]
        holder.title.text = task.title
        holder.description.text = task.description
    }

    override fun getItemCount(): Int = tasks.size

    fun addTask(task : Task) {
        tasks.add(task)
        notifyItemInserted(tasks.size - 1)
    }
}