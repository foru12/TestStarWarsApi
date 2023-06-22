package com.bachersoftltd.starsworstest.ViewModel.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bachersoftltd.starsworstest.Data.DataAll
import com.bachersoftltd.starsworstest.Data.People.DataPeople
import com.bachersoftltd.starsworstest.Data.Starships.DataStarships
import com.bachersoftltd.starsworstest.R
import java.util.*
import kotlin.collections.ArrayList

class AdapterFavorites (

    var dataAll: List<DataAll>,



) : RecyclerView.Adapter<AdapterFavorites.ViewHolder>() {



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val name: TextView = itemView.findViewById(R.id.txt_name)
        val pol: TextView = itemView.findViewById(R.id.txt_pol)
        val count: TextView = itemView.findViewById(R.id.txt_count)
        val pass: TextView = itemView.findViewById(R.id.txt_pass)
        val favourites_im: ImageView = itemView.findViewById(R.id.favourites_im)
        fun bind(names: String) {
            name.text = names
        }






    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterFavorites.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_wars, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AdapterFavorites.ViewHolder, position: Int) {


        var listData: DataAll = dataAll.get(position)

        holder.bind(listData.name.toString())
        holder.pass.text = "${listData.pass}"
        holder.pol.text = "${listData.pol}"
        holder.count.text = "${listData.count}"
        holder.favourites_im.setImageResource(R.drawable.favourites_true)
    }



    override fun getItemCount() =dataAll.size



}