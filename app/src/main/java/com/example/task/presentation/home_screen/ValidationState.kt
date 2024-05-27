package com.example.task.presentation.home_screen

sealed class ValidationState {
    data object InvalidName : ValidationState()
    data object InvalidAge : ValidationState()
    data object InvalidJobTitle : ValidationState()
    data object InvalidGender : ValidationState()
    data object Success : ValidationState()
}