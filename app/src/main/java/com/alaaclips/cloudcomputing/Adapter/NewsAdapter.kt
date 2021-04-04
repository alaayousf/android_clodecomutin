package com.alaaclips.cloudcomputing.Adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alaaclips.cloudcomputing.Model.Product
import com.alaaclips.cloudcomputing.R
import com.alaaclips.cloudcomputing.ThreeActivity


class NewsAdapter(var activity: Activity, var data: List<Product>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var titel = itemView.findViewById<TextView>(R.id.itemdatagit);


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView = LayoutInflater.from(activity).inflate(R.layout.itemdata, parent, false)
        return NewsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.titel.text = data[position].name
        holder.titel.setOnClickListener {
            var i = Intent(activity,ThreeActivity::class.java)
            i.putExtra("typ",data[position].typ)
            i.putExtra("image",data[position].image)
            i.putExtra("name",data[position].name)
            activity.startActivity(i)
        }
    }


}