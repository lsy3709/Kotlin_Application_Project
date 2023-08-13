package com.example.myapplication.weather_imgfind.net

import android.app.Application
import androidx.multidex.MultiDex
import com.example.myapplication.FishingContent.FishService
import com.google.firebase.FirebaseApp
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class APIApplication : Application(){

    var tideService : NetworkService
    var temperService : TemperService
    var fishService : FishService

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        MultiDex.install(this)
    }


    val retrofit : Retrofit
        get() = Retrofit.Builder()
            .baseUrl("http://www.khoa.go.kr/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val retrofit2 : Retrofit
        get() = Retrofit.Builder()
            .baseUrl("http://apis.data.go.kr/1360000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val retrofit3 : Retrofit
        get() = Retrofit.Builder()
            .baseUrl("http://10.100.103.21:8088/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    init {
        tideService = retrofit.create(NetworkService::class.java)
        temperService = retrofit2.create(TemperService::class.java)
        fishService = retrofit3.create(FishService::class.java)

    }

}