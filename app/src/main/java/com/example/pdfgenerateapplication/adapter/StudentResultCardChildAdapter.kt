package com.example.pdfgenerateapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pdfgenerateapplication.databinding.RecyclerItem2Binding
import com.example.pdfgenerateapplication.model.StudentRecord


class StudentResultCardChildAdapter( val list: ArrayList<StudentRecord>): RecyclerView.Adapter<StudentResultCardChildAdapter.MyViewHolder2>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder2 {
        val binding = RecyclerItem2Binding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder2(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder2, position: Int) {
        holder.binding.tvDate1.text= list[position].EvaluationDateString
        holder.binding.tvSubject1.text= list[position].Subject
        holder.binding.tvTotalMarks1.text= list[position].TotalMarks.toString()
        holder.binding.tvObtMarks1.text= list[position].ObtainedMarks.toString()
        holder.binding.tvPercentage1.text= list[position].Percentage.toString()

    }
    inner class MyViewHolder2(val binding: RecyclerItem2Binding):RecyclerView.ViewHolder(binding.root)

}