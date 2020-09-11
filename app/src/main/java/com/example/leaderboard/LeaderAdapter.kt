package com.example.leaderboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class LeaderAdapter(val context: Context): RecyclerView.Adapter<LeaderAdapter.MyViewHolder>(){

    var leaderList: List<Leader> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvName.text = leaderList.get(position).name
        holder.tvProgress.text = leaderList.get(position).hours.toString()+","+
                leaderList.get(position).country
        Glide.with(context).load(leaderList.get(position).image)
            .apply(RequestOptions().centerCrop())
            .into(holder.image)
    }
    fun setLeaderListItems(leaderList: List<Leader>){
        this.leaderList = leaderList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return leaderList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val tvName: TextView = itemView!!.findViewById(R.id.tvName)
        val image: ImageView = itemView!!.findViewById(R.id.imageView)
        val tvProgress: TextView = itemView!!.findViewById(R.id.tvProgress)
    }

}