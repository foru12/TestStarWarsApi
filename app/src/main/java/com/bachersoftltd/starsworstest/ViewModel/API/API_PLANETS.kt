package com.bachersoftltd.starsworstest.ViewModel.API

import com.bachersoftltd.starsworstest.Data.CONST
import com.bachersoftltd.starsworstest.Data.Planets.DataApiPlanets
import io.reactivex.Observable
import retrofit2.http.GET

interface API_PLANETS {
    @GET(CONST.DATA_PLANETS)
    fun getPlanets(): Observable<DataApiPlanets?>?
}