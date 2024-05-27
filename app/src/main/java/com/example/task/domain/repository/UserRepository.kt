package com.example.task.domain.repository

import com.example.task.domain.model.UserDomainModel
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun insertUser(user: UserDomainModel)
    fun getAllUser(): Flow<List<UserDomainModel>>
}