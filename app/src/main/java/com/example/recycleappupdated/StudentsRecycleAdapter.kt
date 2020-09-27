package com.example.recycleappupdated

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class StudentsRecycleAdapter (val context: Context, val students : List<Student>) : RecyclerView.Adapter<StudentsRecycleAdapter.ViewHolder>() {
    val layoutInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.studen_list_view, parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = students[position]
        holder.textName.text = student.name
        holder.textClassName.text = student.className
        holder.doneButton.isChecked = student.done
        holder.studentPosition = position
    }

    override fun getItemCount() = students.size

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val textName = itemView.findViewById<TextView>(R.id.nameTextView)
        val textClassName = itemView.findViewById<TextView>(R.id.classTextView)
        val doneButton = itemView.findViewById<CheckBox>(R.id.checkBox)
        val deleteButton = itemView.findViewById<ImageButton>(R.id.deleteButton)
        var studentPosition = 0

        init {
            doneButton.setOnClickListener {
                DataManager.students[studentPosition].done = doneButton.isChecked
                Toast.makeText(context, "${DataManager.students[studentPosition].name} is done",
                    Toast.LENGTH_SHORT).show()
            }
            deleteButton.setOnClickListener {
                DataManager.students.removeAt(studentPosition)
                notifyDataSetChanged()
                Toast.makeText(context, "${DataManager.students[studentPosition].name} deleted",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}