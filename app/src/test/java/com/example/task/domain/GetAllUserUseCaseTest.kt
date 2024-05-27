package com.example.task.domain

import com.example.task.domain.model.UserDomainModel
import com.example.task.domain.repository.UserRepository
import com.example.task.domain.usecase.GetAllUserUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class GetAllUserUseCaseTest {

    @Mock
    private lateinit var userRepository: UserRepository

    private lateinit var getAllUserUseCase: GetAllUserUseCase

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        getAllUserUseCase = GetAllUserUseCase(userRepository)
    }

    @Test
    fun `test get all user useCase return flow of user domain models`() = runBlocking {

        val userDomainModels = listOf(
            UserDomainModel(1, "essam", 15, "sw", gender = "m"),
            UserDomainModel(2, "mohamed", 16, "doc", gender = "m"),
        )
        `when`(userRepository.getAllUser()).thenReturn(
            flowOf(userDomainModels)
        )


        val result = getAllUserUseCase.invoke().toList()

        assertEquals(userDomainModels, result.first())

    }
}