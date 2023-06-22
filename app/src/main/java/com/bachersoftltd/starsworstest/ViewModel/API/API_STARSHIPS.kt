package com.bachersoftltd.starsworstest.ViewModel.API

import com.bachersoftltd.starsworstest.Data.CONST.DATA_STARSHIPS
import com.bachersoftltd.starsworstest.Data.Starships.DataApiStartships
import io.reactivex.Observable
import retrofit2.http.GET

interface API_STARSHIPS {
    @GET(DATA_STARSHIPS)
    fun getStarhips(): Observable<DataApiStartships?>?
}