package com.example.task.presentation.all_user_screen

import androidx.lifecycle.ViewModel
import com.example.task.domain.model.UserDomainModel
import com.example.task.domain.usecase.GetAllUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class AllUserViewModel @Inject constructor(
    private val getAllUserUseCase: GetAllUserUseCase
) : ViewModel() {

    fun getAllUsers(): Flow<List<UserDomainModel>> {
        return getAllUserUseCase()
    }
}