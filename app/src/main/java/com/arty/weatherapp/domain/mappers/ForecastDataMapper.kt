package com.arty.weatherapp.domain.mappers

import com.arty.weatherapp.data.Forecast
import com.arty.weatherapp.data.ForecastResult
import com.arty.weatherapp.domain.model.ForecastList
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import com.arty.weatherapp.domain.model.Forecast as ForecastModel


class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult) : ForecastList =
            ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))

    private fun convertForecastListToDomain(list: List<Forecast>) : List<ForecastModel> {
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast) : ForecastModel =
            ForecastModel(convertDate(forecast.dt), forecast.weather[0].description,
                    forecast.temp.max.toInt(), forecast.temp.min.toInt())

    private fun convertDate(date: Long) : String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date)
    }
}