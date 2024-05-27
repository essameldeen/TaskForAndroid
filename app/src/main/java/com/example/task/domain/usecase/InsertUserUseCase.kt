package com.example.task.domain.usecase

import com.example.task.domain.model.UserDomainModel
import com.example.task.domain.repository.UserRepository

class InsertUserUseCase(private val userRepository: UserRepository) {

    suspend operator fun invoke(user: UserDomainModel) {
        userRepository.insertUser(user)
    }
}