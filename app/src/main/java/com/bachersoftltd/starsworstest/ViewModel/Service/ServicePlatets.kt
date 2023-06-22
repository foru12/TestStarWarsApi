package com.bachersoftltd.starsworstest.ViewModel.Service

import android.util.Log
import com.bachersoftltd.starsworstest.ViewModel.API.API_PLANETS
import com.bachersoftltd.starsworstest.ViewModel.CallBack.Planets.CallBackInterfacePlanets
import com.bachersoftltd.starsworstest.ViewModel.CallBack.Planets.CallBackRequestPlanets
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ServicePlatets: CallBackInterfacePlanets {

        private var myCompositeDisposable: CompositeDisposable? = null
        override   fun execute(
            url: String?,
            callback: CallBackRequestPlanets?,
        ) {
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
                .create(API_PLANETS::class.java)


            retrofit.getPlanets()
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.doOnError {
                    Log.e("Error Planets","!!!")
                }
                ?.subscribeOn(Schedulers.io())?.let {
                    myCompositeDisposable?.add(
                        it
                            .subscribe({
                                try {
                                    callback?.successReq(it);
                                    Log.e("Subscribe","...")
                                }catch (e:Throwable){
                                    Log.e("Error Planets","!!!")
                                }

                            }))
                }
        }

        override fun clear() {

            myCompositeDisposable?.clear()
        }
}
