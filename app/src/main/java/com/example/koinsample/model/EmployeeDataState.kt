package com.example.koinsample.model

data class EmployeeDataState(
    val showProgress: Boolean,
    val employee: List<Employee>?,
    val error: Int
)
