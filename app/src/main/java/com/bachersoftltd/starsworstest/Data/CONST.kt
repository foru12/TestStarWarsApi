package com.bachersoftltd.starsworstest.Data

import android.provider.ContactsContract.RawContacts.Data

object CONST {
    private external fun baseUrlFromJNI(boolean: Boolean): String

    const val BASE_URL = "https://swapi.dev/"

    private const val V1 = "api/"



    const val DATA_STARSHIPS = V1 + "starships"
    const val DATA_PLANETS = V1 + "planets"
    const val DATA_PEOPLE = V1 + "people"

    val data = mutableListOf<DataAll>()

}