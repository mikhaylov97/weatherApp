package com.arty.weatherapp.domain.commands

import com.arty.weatherapp.data.server.ForecastRequest
import com.arty.weatherapp.domain.mappers.ForecastDataMapper
import com.arty.weatherapp.domain.model.ForecastList


class RequestForecastCommand(private val zipCode: Long) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(zipCode, forecastRequest.execute())
    }
}