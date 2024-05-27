package com.example.task.data.mapper

import com.example.task.data.model.UserEntity
import com.example.task.domain.model.UserDomainModel


fun UserDomainModel.toNoteEntityModel(): UserEntity {
    return UserEntity(
        id = this.id,
        name = this.name,
        age = this.age,
        jobTitle = this.jobTitle,
        gender = this.gender
    )
}

fun UserEntity.toUserDomainModel(): UserDomainModel {
    return UserDomainModel(
        id = this.id,
        name = this.name,
        age = this.age,
        jobTitle = this.jobTitle,
        gender = this.gender
    )
}