package com.example.weatherapp.data

data class CityWeatherResponse(
    val name: String,
    val weather: List<WeatherItem>,
    val main: Main,
    val sys: Sys
) {
    data class WeatherItem(
        val main: String,
        val description: String
    )

    data class Main(
        val temp: Float
    )

    data class Sys(
        val country: String
    )
}