package uk.org.websolution.weatherapp.ui.main.viewmodel

import uk.org.websolution.weatherapp.ui.main.model.Weather

sealed class AppState {
    data class Success(val weatherData: List<Weather>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}