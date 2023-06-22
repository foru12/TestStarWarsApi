package com.bachersoftltd.starsworstest.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.bachersoftltd.starsworstest.Data.CONST.data
import com.bachersoftltd.starsworstest.R
import com.bachersoftltd.starsworstest.ViewModel.Adapters.AdapterFavorites
import com.bachersoftltd.starsworstest.ViewModel.Adapters.AdapterStarWars

class FavoriteActivity : AppCompatActivity() {
    lateinit var rc_view : RecyclerView
    private var myAdapter: AdapterFavorites? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)


        initAdapter()
    }

    private fun initAdapter() {
        rc_view = findViewById(R.id.rc_view)
        rc_view.setAlpha(0f)
        rc_view.animate().alpha(1f).setDuration(1300)
        myAdapter = AdapterFavorites(data)
        rc_view.adapter = myAdapter
        myAdapter?.notifyDataSetChanged()

    }
}