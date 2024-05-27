package com.example.task.domain.usecase

import com.example.task.domain.model.UserDomainModel
import com.example.task.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetAllUserUseCase(private val userRepository: UserRepository) {

    operator fun invoke(): Flow<List<UserDomainModel>> = userRepository.getAllUser()
}