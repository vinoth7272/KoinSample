package com.example.koinsample.di

import com.example.koinsample.Util.Constant
import com.example.koinsample.model.EmployeeApi
import com.example.koinsample.viewmodel.EmployeeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {
    single {
        getEmployeeService(Constant.BASE_URL)
    }
    viewModel{EmployeeViewModel(get())}
}

private fun getEmployeeService(baseUrl: String): EmployeeApi {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(EmployeeApi::class.java)
}