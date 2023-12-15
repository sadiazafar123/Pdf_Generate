package com.example.pdfgenerateapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pdfgenerateapplication.databinding.RecyclerItem1Binding
import com.example.pdfgenerateapplication.model.EvaluationDetail

class StudentResultCardAdapter(val list: ArrayList<EvaluationDetail>)
    :RecyclerView.Adapter<StudentResultCardAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RecyclerItem1Binding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(binding)

        }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var totalMarks= 0
        var obtMarks= 0.0f
        holder.binding.tvEvaluationType.text= list[position].EvaluationName
        for (i in 0 until list[position].EvaluationDetails.size){
            totalMarks = totalMarks.plus(list[position].EvaluationDetails[i].TotalMarks)
            obtMarks = obtMarks.plus(list[position].EvaluationDetails[i].ObtainedMarks)
        }
        val percentage= (obtMarks*100)/totalMarks
        holder.binding.tvTotalMarks1.text=totalMarks .toString()
        holder.binding.tvObtMarks1.text= obtMarks.toString()
        holder.binding.tvPercentage1.text=  "$percentage %"
        holder.binding.childRecyclerView.adapter= StudentResultCardChildAdapter(list[position].EvaluationDetails)


    }

   inner class MyViewHolder( val binding: RecyclerItem1Binding): RecyclerView.ViewHolder(binding.root)

}