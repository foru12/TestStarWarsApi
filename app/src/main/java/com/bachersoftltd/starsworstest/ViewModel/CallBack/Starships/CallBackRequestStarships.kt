package com.bachersoftltd.starsworstest.ViewModel.CallBack.Starships

import com.bachersoftltd.starsworstest.Data.Starships.DataApiStartships

interface CallBackRequestStarships {
    fun successReq(response: DataApiStartships?)
    fun errorReq(error: String?)
}