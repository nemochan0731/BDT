package com.example.bdt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class bdAdapter internal constructor(context: Context ): RecyclerView.Adapter<bdAdapter.bdViewHolder>(){
    private val inflater :LayoutInflater = LayoutInflater.from(context)
    private var bds = emptyList<DB>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bdViewHolder {
val itemView=inflater.inflate(R.layout.recyclerview_item,parent,false)
        return bdViewHolder(itemView)
    }

    override fun getItemCount(): Int {
return bds.size
    }

    override fun onBindViewHolder(holder: bdViewHolder, position: Int) {
val bdRecord = bds.get(position)
        holder.textViewName.text= bdRecord.name
        holder.textViewDOB.text= bdRecord.dob

    }

   internal  fun setBDS (bds : List<DB>){
       this.bds= bds
       notifyDataSetChanged()

   }


    inner class bdViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){

        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewDOB: TextView = itemView.findViewById(R.id.textViewDOB)


    }
}