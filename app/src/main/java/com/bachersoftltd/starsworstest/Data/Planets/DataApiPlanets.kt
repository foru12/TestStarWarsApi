package com.bachersoftltd.starsworstest.Data.Planets

import com.google.gson.annotations.SerializedName

data class DataApiPlanets(
    @SerializedName("count"    ) var count    : Int,
    @SerializedName("next"     ) var next     : String,
    @SerializedName("previous" ) var previous : String,
    @SerializedName("results"  ) var resultsPlanets  : ArrayList<DataPlanets> = arrayListOf(),
)
