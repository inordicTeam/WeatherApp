package com.example.weatherapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weatherapp.R
import com.example.weatherapp.data.WeatherRepository
import kotlinx.android.synthetic.main.fragment_current_city_weather.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CityWeatherFragment : Fragment(), CoroutineScope {
    override val coroutineContext = Dispatchers.Main
    private val repository = WeatherRepository()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_current_city_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        searchButton.setOnClickListener {
            val inputCity = inputCity.text.toString()
            val inputCountryCode = inputCountryCode.text.toString()


            if (inputCity.isEmpty() || inputCity.isBlank()) return@setOnClickListener

            launch {
                val response = repository.getCurrentWeatherForCity(inputCity, inputCountryCode)
                response?.apply {
                    cityName.text = name
                    countryCode.text = sys.country
                    weatherDescription.text = weather[0].description
                    weatherTemperature.text = getString(R.string.temperature_format).format(main.temp.toString())
                }

            }

        }
    }
}