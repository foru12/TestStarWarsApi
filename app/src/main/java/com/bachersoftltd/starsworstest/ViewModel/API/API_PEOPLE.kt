package com.bachersoftltd.starsworstest.ViewModel.API

import com.bachersoftltd.starsworstest.Data.CONST
import com.bachersoftltd.starsworstest.Data.People.DataApiPeople
import io.reactivex.Observable
import retrofit2.http.GET

interface API_PEOPLE {
    @GET(CONST.DATA_PEOPLE)
    fun getPeople(): Observable<DataApiPeople?>?
}