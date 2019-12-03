package com.example.week7_1

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.model_layout.view.*

class MyAdapter(var dataList : List<DataModel>, var context: Context)

    :RecyclerView.Adapter<ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.model_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try{
            holder?.textView.text  = dataList.get(position).title
            Glide.with(context).load(dataList.get(position).url).into(holder?.imageView)
        }catch (errorVar : Exception){
            Log.e("Error", errorVar.message)
        }

        holder?.textView.text = dataList.get(position).toString()
    }

}

class ViewHolder(view: View): RecyclerView.ViewHolder(view){
    var imageView = view.img_photo
    var textView = view.tv_title
}