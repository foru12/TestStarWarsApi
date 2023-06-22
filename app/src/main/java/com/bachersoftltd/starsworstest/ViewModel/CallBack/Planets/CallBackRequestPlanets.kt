package com.bachersoftltd.starsworstest.ViewModel.CallBack.Planets

import com.bachersoftltd.starsworstest.Data.Planets.DataApiPlanets

interface CallBackRequestPlanets {
    fun successReq(response: DataApiPlanets?)
    fun errorReq(error: String?)
}