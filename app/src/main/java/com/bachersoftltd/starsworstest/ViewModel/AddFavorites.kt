package com.bachersoftltd.starsworstest.ViewModel

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.util.Log
import com.bachersoftltd.starsworstest.Data.CONST.data
import com.bachersoftltd.starsworstest.Data.DataAll
import com.bachersoftltd.starsworstest.ViewModel.Adapters.AdapterStarWars

class AddFavorites : AddView {




    override fun addView(
        name: String,
        count: String,
        pol: String,
        pass: String,
    ) {
        Log.e("ASDSAD", name + "   " + count)

        data.add(DataAll(name, count,pol,pass))

    }
}