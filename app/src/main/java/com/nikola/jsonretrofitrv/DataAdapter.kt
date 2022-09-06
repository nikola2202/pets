package com.nikola.jsonretrofitrv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(val context: Context, val dataList: List<Pet>) : RecyclerView.Adapter<DataAdapter.ViewHolder>()
{
    inner class ViewHolder(dataView: View) : RecyclerView.ViewHolder(dataView)
    {
        val nameHolder: TextView = dataView.findViewById(R.id.tv_name)
        val speciesHolder: TextView = dataView.findViewById(R.id.tv_species)
        val imageHolder: ImageView = dataView.findViewById(R.id.image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card,parent,false)

        return ViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {

        val currentItem = dataList[position]

        //holder.imageHolder.setImageResource(currentItem.photo)
        holder.nameHolder.text = currentItem.name
        holder.speciesHolder.text = currentItem.species


    }

    override fun getItemCount(): Int
    {
        return dataList.size
    }
}