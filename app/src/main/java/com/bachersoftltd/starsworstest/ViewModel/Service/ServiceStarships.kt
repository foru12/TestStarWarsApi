package com.bachersoftltd.starsworstest.ViewModel.Service

import android.util.Log
import com.bachersoftltd.starsworstest.ViewModel.API.API_PEOPLE
import com.bachersoftltd.starsworstest.ViewModel.API.API_STARSHIPS
import com.bachersoftltd.starsworstest.ViewModel.CallBack.People.CallBackInterfacePeople
import com.bachersoftltd.starsworstest.ViewModel.CallBack.Starships.CallBackInterfaceStarships
import com.bachersoftltd.starsworstest.ViewModel.CallBack.Starships.CallBackRequestStarships
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ServiceStarships: CallBackInterfaceStarships {
    private var myCompositeDisposable: CompositeDisposable? = null

    override  fun execute(url: String?, callback: CallBackRequestStarships?) {
        Log.e("Запуск Retrofit","...")
        myCompositeDisposable = CompositeDisposable()
        val client: OkHttpClient.Builder = OkHttpClient.Builder()
        client.connectTimeout(15, TimeUnit.SECONDS)
        client.readTimeout(15, TimeUnit.SECONDS)
        client.writeTimeout(15, TimeUnit.SECONDS)
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client.build())
            .build()
            .create(API_STARSHIPS::class.java)


        retrofit.getStarhips()

            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError {
                Log.e("Error Starships","!!!")
            }
            ?.subscribeOn(Schedulers.io())?.let {
                myCompositeDisposable?.add(
                    it
                        .subscribe({
                            try {
                                callback?.successReq(it);
                                Log.e("Subscribe","...")
                            }catch (
                                e:Throwable
                            ){
                                Log.e("Error Starships","!!!")
                            }

                        }))
            }
        }

    override fun clear() {
        myCompositeDisposable?.clear()
    }

}
