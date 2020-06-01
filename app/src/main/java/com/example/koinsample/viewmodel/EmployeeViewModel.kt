package com.example.koinsample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koinsample.model.ApiResponse
import com.example.koinsample.model.EmployeeApi
import kotlinx.coroutines.*

class EmployeeViewModel(val employeeApi: EmployeeApi) : ViewModel() {
    val employeeApiResponse = MutableLiveData<ApiResponse>()
    val employeeDataState = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()
    private val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        employeeDataState.value = "Exception : ${throwable.localizedMessage}"
    }
    private var job: Job? = null


    fun getEmployees() {
        loading.value = true

        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = employeeApi.getEmployees()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    loading.value = false
                    employeeDataState.value = null
                    employeeApiResponse.value = response.body()
                } else {
                    loading.value = true
                    employeeDataState.value = response.message()
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}