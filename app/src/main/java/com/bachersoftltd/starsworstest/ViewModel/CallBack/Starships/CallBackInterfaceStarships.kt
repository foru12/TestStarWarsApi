package com.bachersoftltd.starsworstest.ViewModel.CallBack.Starships

import com.bachersoftltd.starsworstest.ViewModel.CallBack.People.CallBackRequestPeople

interface CallBackInterfaceStarships {
     fun execute(url: String?, callback:CallBackRequestStarships ?)
    fun clear()
}