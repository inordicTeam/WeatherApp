package com.example.weatherapp.data

data class CityWeatherResponse(
    val name: String,
    val weather: List<WeatherItem>,
    val main: Main,
    val sys: Sys,
    val wind: Wind
) {
    data class WeatherItem(
        val main: String,
        val description: String
    )

    data class Main(
        val temp: Float,
        val humidity: Int
    )

    data class Sys(
        val country: String
    )

    data class Wind(
        val speed: Float
    )
}