package com.example.task.domain

import com.example.task.domain.model.UserDomainModel
import com.example.task.domain.repository.UserRepository
import com.example.task.domain.usecase.InsertUserUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class InsertUserUseCaseTest {
    @Mock
    private lateinit var userRepository: UserRepository

    private lateinit var insertUserUseCase: InsertUserUseCase

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        insertUserUseCase = InsertUserUseCase(userRepository)
    }

    @Test
    fun `test insert user uesCase should insert user into the repository()`() = runBlocking {
        val user = UserDomainModel(1, "essam", 15, "sw", gender = "m")
        insertUserUseCase.invoke(user)
        verify(userRepository).insertUser(user)
    }
}