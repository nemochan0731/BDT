package com.example.bdt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class bdAdapter internal constructor(context: Context ): RecyclerView.Adapter<bdAdapter.bdViewHolder>(){
    private val inflater :LayoutInflater = LayoutInflater.from(context)
    private var bds = emptyList<DB>()
    public val context1:Context = context

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
        holder.textViewDOB.text= bdRecord.dob.toString()
        holder.button.text=bdRecord.id.toString()

        holder.aview.setOnClickListener {
            Toast.makeText(context1,position.toString(), Toast.LENGTH_LONG).show()
        }




    }

   internal  fun setBDS (bds : List<DB>){
       this.bds= bds
       notifyDataSetChanged()

   }


    inner class bdViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
        val aview: LinearLayout = itemView.findViewById(R.id.recycleviewtest)
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewDOB: TextView = itemView.findViewById(R.id.textViewDOB)
        val button:Button = itemView.findViewById(R.id.buttonShow)
    }
}