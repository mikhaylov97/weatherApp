package com.arty.weatherapp.domain.datasource

import com.arty.weatherapp.domain.model.Forecast
import com.arty.weatherapp.domain.model.ForecastList

interface ForecastDataSource {

    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?

    fun requestDayForecast(id: Long): Forecast?

}
