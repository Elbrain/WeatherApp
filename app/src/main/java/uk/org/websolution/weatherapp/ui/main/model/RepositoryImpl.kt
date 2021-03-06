package uk.org.websolution.weatherapp.ui.main.model

class RepositoryImpl : Repository {
    override fun getWeatherFromServer(): Weather {
        return Weather()
    }
    override fun getWeatherFromLocalStorageRus(): List<Weather> {
        return getRussianCities()
    }
    override fun getWeatherFromLocalStorageWorld(): List<Weather> {
        return getWorldCities()
    }
}