package com.bachersoftltd.starsworstest.Data.People

import com.google.gson.annotations.SerializedName

data class DataApiPeople(
    @SerializedName("count"    ) var count    : Int,
    @SerializedName("next"     ) var next     : String,
    @SerializedName("previous" ) var previous : String,
    @SerializedName("results"  ) var resultsPeople  : ArrayList<DataPeople> = arrayListOf(),
)