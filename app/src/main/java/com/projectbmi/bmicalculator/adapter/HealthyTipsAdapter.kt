package com.projectbmi.bmicalculator.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.projectbmi.bmicalculator.R
import com.projectbmi.bmicalculator.model.Healthy
//implement all the three methods of the adapter here
class HealthyTipsAdapter (val tipsList:List<Healthy>):RecyclerView.Adapter<HealthyTipsAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent:ViewGroup,viewType:Int):ViewHolder{
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_tip, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder:ViewHolder,position:Int){
        val tip=tipsList[position]
        holder.titleTextView.text=tip.title//refrence to the data class under model package
        holder.contentTextView.text=tip.content
    }

    override fun getItemCount():Int{
        return tipsList.size
    }

    class ViewHolder(val itemView:View):RecyclerView.ViewHolder(itemView){
        //declare and initialize all of the list item ui components
        val titleTextView:TextView=itemView.findViewById(R.id.bmi_title)
        val contentTextView: TextView = itemView.findViewById(R.id.bmi_content)


    }




}