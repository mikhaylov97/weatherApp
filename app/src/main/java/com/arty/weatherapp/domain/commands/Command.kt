package com.arty.weatherapp.domain.commands


interface Command<out T> {
    fun execute(): T
}