package com.arty.weatherapp.domain.commands

import com.arty.weatherapp.domain.datasource.ForecastProvider
import com.arty.weatherapp.domain.model.Forecast

class RequestDayForecastCommand(
        val id: Long,
        private val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<Forecast> {

    override fun execute() = forecastProvider.requestForecast(id)
}
