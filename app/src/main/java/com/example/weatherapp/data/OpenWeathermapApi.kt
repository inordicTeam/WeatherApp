package com.example.weatherapp.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeathermapApi {

    @GET("data/2.5/weather?appid=265c7fb04308fa7e744f9ee8aa2220bd")
    fun getCurrentWeatherForCity(
        @Query("q") cityAndCountry: String,
        @Query("units") units: String = "metric"
    ): Call<CityWeatherResponse>
}