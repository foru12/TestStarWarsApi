package com.bachersoftltd.starsworstest.Data.Starships

import com.google.gson.annotations.SerializedName

data class DataStarships(
    @SerializedName("name"                   ) var name                 : String?           = null,
    @SerializedName("model"                  ) var model                : String?           = null,
    @SerializedName("manufacturer"           ) var manufacturer         : String?           = null,
    @SerializedName("cost_in_credits"        ) var costInCredits        : String?           = null,
    @SerializedName("length"                 ) var length               : String?           = null,
    @SerializedName("max_atmosphering_speed" ) var maxAtmospheringSpeed : String?           = null,
    @SerializedName("crew"                   ) var crew                 : String?           = null,
    @SerializedName("passengers"             ) var passengers           : String?           = null,
    @SerializedName("cargo_capacity"         ) var cargoCapacity        : String?           = null,
    @SerializedName("consumables"            ) var consumables          : String?           = null,
    @SerializedName("hyperdrive_rating"      ) var hyperdriveRating     : String?           = null,
    @SerializedName("MGLT"                   ) var MGLT                 : String?           = null,
    @SerializedName("starship_class"         ) var starshipClass        : String?           = null,
    @SerializedName("pilots"                 ) var pilots               : ArrayList<String> = arrayListOf(),
    @SerializedName("films"                  ) var films                : ArrayList<String> = arrayListOf(),
    @SerializedName("created"                ) var created              : String?           = null,
    @SerializedName("edited"                 ) var edited               : String?           = null,
    @SerializedName("url"                    ) var url                  : String?           = null
)
