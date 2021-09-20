package uk.org.websolution.weatherapp.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uk.org.websolution.weatherapp.ui.main.model.Repository
import uk.org.websolution.weatherapp.ui.main.model.RepositoryImpl
import java.lang.Thread.sleep
import kotlin.random.Random

class MainViewModel : ViewModel() {

    private val liveDataToObserve: MutableLiveData<Any> = MutableLiveData()
    private val repositoryImpl: Repository = RepositoryImpl()

    fun getLiveData() = liveDataToObserve
    fun getWeatherFromLocalSourceRus() = getDataFromLocalSource(isRussian = true)
    fun getWeatherFromLocalSourceWorld() = getDataFromLocalSource(isRussian =
    false)
    fun getWeatherFromRemoteSource() = getDataFromLocalSource(isRussian = true)

    private fun getDataFromLocalSource(isRussian: Boolean) {
        liveDataToObserve.value = AppState.Loading
        Thread {
            sleep(1000)
            liveDataToObserve.postValue(AppState.Success(if (isRussian)
                repositoryImpl.getWeatherFromLocalStorageRus() else
                repositoryImpl.getWeatherFromLocalStorageWorld()))
        }.start()
    }

}