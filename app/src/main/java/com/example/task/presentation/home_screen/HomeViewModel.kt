package com.example.task.presentation.home_screen


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task.domain.model.UserDomainModel
import com.example.task.domain.usecase.InsertUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val insertUserUseCase: InsertUserUseCase
) : ViewModel() {


    private val _validationState = MutableStateFlow<ValidationState?>(null)
    val validationState: StateFlow<ValidationState?> = _validationState

    fun insertUser(name: String, age: String, jobTitle: String, gender: String) {
        when {
            name.isBlank() -> {
                _validationState.value = ValidationState.InvalidName
            }

            age.isBlank() -> {
                _validationState.value = ValidationState.InvalidAge
            }

            jobTitle.isBlank() -> {
                _validationState.value = ValidationState.InvalidJobTitle
            }

            gender.isBlank() -> {
                _validationState.value = ValidationState.InvalidGender
            }

            else -> {
                val user = UserDomainModel(
                    name = name,
                    age = age.toInt(),
                    jobTitle = jobTitle,
                    gender = gender
                )
                viewModelScope.launch {
                    insertUserUseCase(user)
                }
                _validationState.value = ValidationState.Success
                _validationState.value = null
            }
        }
    }
}