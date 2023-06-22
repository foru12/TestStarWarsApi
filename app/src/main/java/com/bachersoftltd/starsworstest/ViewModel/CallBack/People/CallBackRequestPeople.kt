package com.bachersoftltd.starsworstest.ViewModel.CallBack.People

import com.bachersoftltd.starsworstest.Data.People.DataApiPeople

interface CallBackRequestPeople {
    fun successReq(response: DataApiPeople?)
    fun errorReq(error: String?)
}