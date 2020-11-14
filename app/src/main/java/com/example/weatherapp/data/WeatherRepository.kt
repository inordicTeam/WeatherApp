package com.example.weatherapp.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherRepository {
    private val coroutineContext = Dispatchers.IO
    private val openWeathermapApi = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(OpenWeathermapApi::class.java)

    suspend fun getCurrentWeatherForCity(city: String, countryCode: String) = withContext(coroutineContext) {
        val cityAndCode = "$city,$countryCode"

        openWeathermapApi.getCurrentWeatherForCity(cityAndCode)
            .execute()
            .body()
    }
}