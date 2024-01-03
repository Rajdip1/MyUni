package com.example.myuni

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val universityList: ArrayList<UniversityInfo>, val context : Activity):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    //to create new view instance
    //when layout manager fails to find suitable view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.university_list,parent,false)
        return MyViewHolder(itemView)
    }

    //populate items with data
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem = universityList[position]
        holder.hName.text = currentItem.universityName
        holder.hImg.setImageResource(currentItem.universityImage)
    }

    //how many list items are present in your array
    override fun getItemCount(): Int {
        return universityList.size
    }

    //it holds the view so views are not created everytime, so memory can be saved
    class MyViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        val hName = itemView.findViewById<TextView>(R.id.universityName)
        val hImg = itemView.findViewById<ShapeableImageView>(R.id.universityImage)
    }
}