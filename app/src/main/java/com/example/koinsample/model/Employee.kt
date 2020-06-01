package com.example.koinsample.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable


data class Employee(
    @SerializedName("id")
    val id: Int,
    @SerializedName("employee_name")
    val employeeName: String,

    @SerializedName("employee_salary")
    val emlployeeSal: String,

    @SerializedName("employee_age")
    val employeeAge: Int
)