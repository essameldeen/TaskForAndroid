package com.example.task.domain.model

data class UserDomainModel(
    val id: Long = 0,
    val name: String,
    val age: Int,
    val jobTitle: String,
    val gender: String
)
