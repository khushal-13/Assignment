package com.example.assignment

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(private val context : Activity, private val productArrayList: List<Product>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productArrayList[position]
        holder.tittle.text = currentItem.title
        Picasso.get().load(currentItem.thumbnail).into(holder.image)
        holder.rating.text = currentItem.description
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tittle : TextView
        val image  : ImageView
        val rating : TextView

        init {
            tittle = itemView.findViewById(R.id.productTittle)
            image  = itemView.findViewById(R.id.productImage)
            rating = itemView.findViewById(R.id.description)
        }
    }
}