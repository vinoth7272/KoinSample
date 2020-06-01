package com.example.koinsample.model

import kotlinx.serialization.Serializable

data class ApiResponse(
    @Serializable
    val status: String,

    @Serializable
    val data: List<Employee>
)