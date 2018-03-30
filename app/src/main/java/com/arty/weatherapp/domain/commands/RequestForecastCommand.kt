package com.arty.weatherapp.domain.commands

import com.arty.weatherapp.data.ForecastRequest
import com.arty.weatherapp.data.ForecastResult
import com.arty.weatherapp.domain.mappers.ForecastDataMapper
import com.arty.weatherapp.domain.model.ForecastList


class RequestForecastCommand(private val zipCode: String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}