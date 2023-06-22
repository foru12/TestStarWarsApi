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
import com.bachersoftltd.starsworstest.Data.People.DataPeople
import com.bachersoftltd.starsworstest.Data.Planets.DataPlanets
import com.bachersoftltd.starsworstest.Data.Starships.DataStarships
import com.bachersoftltd.starsworstest.R
import com.bachersoftltd.starsworstest.ViewModel.AddFavorites
import java.util.*
import kotlin.collections.ArrayList

class AdapterStarWars(
    var dataStahips: ArrayList<DataStarships>,
    var dataPeople: ArrayList<DataPeople>


    ) : RecyclerView.Adapter<AdapterStarWars.ViewHolder>(),Filterable {

    private var firstPlayed = false
    var pos = 0
    private var filteredPeoples: List<DataPeople> = dataPeople
    private var filteredStarhips: List<DataStarships> = dataStahips

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val name: TextView = itemView.findViewById(R.id.txt_name)
        val pol: TextView = itemView.findViewById(R.id.txt_pol)
        val count: TextView = itemView.findViewById(R.id.txt_count)
        val pass: TextView = itemView.findViewById(R.id.txt_pass)
        val falg: TextView = itemView.findViewById(R.id.txt_falg)
        val favourites_im: ImageView = itemView.findViewById(R.id.favourites_im)
        fun bind(names: String) {
            name.text = names
        }






    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterStarWars.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_wars, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AdapterStarWars.ViewHolder, position: Int) {
        val starhipsCount = filteredStarhips.size
        if (position < starhipsCount) {
            val starships = filteredStarhips[position]
            holder.bind(starships.name.toString())
            holder.pass.text = "Passengers ${starships.passengers}"
            holder.pol.text = "Manufacturer ${starships.manufacturer}"
            holder.count.text = "Model ${starships.model}"


        } else {
            val people = filteredPeoples[position - starhipsCount]
            holder.bind(people.name.toString())
            holder.count.text =  "Flew on ${people.starships.size} starships "
            holder.pol.text = people.gender
            holder.pass.text = ""


        }

        holder.itemView.setOnClickListener({

            if (holder.falg.text != "1"){
                Log.e("AddView","....")
                holder.favourites_im.setImageResource(R.drawable.favourites_true)
                holder.falg.text = "1"
                AddFavorites().addView(holder.name.text.toString(),holder.count.text.toString(),holder.pol.text.toString(),holder.pass.text.toString())
            }






        })









    }



    override fun getItemCount() = filteredStarhips.size + filteredPeoples.size
    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filterResults = FilterResults()
                val query = constraint.toString().toLowerCase(Locale.getDefault())

                val filteredStarships =
                    dataStahips.filter { it.name?.toLowerCase(Locale.getDefault())!!.contains(query) }
                val filteredPeoples =
                    dataPeople.filter { it.name?.toLowerCase(Locale.getDefault())!!.contains(query) }

                filterResults.values = Pair(filteredStarships, filteredPeoples)
                filterResults.count = 1

                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                val pair = results?.values as? Pair<List<DataStarships>, List<DataPeople>>
                if (pair != null) {
                    filteredStarhips = pair.first
                    filteredPeoples = pair.second
                    notifyDataSetChanged()
                }
            }
        }
    }


}