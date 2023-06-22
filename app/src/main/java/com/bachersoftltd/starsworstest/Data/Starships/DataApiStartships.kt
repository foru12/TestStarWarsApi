package com.bachersoftltd.starsworstest.Data.Starships

import com.google.gson.annotations.SerializedName

data class DataApiStartships(
    @SerializedName("count"    ) var count    : Int,
    @SerializedName("next"     ) var next     : String,
    @SerializedName("previous" ) var previous : String,
    @SerializedName("results"  ) var resultStarships  : ArrayList<DataStarships> = arrayListOf(),
)
