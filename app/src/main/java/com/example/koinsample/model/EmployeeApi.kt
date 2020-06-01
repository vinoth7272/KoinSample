package com.example.koinsample.model

import retrofit2.Response
import retrofit2.http.GET

interface EmployeeApi {
    @GET("employees")
    suspend fun getEmployees() : Response<ApiResponse>

}