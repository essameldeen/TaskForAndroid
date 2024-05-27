package com.example.task.data.repository

import com.example.task.data.dataBase.UserDao
import com.example.task.data.mapper.toNoteEntityModel
import com.example.task.data.mapper.toUserDomainModel
import com.example.task.domain.model.UserDomainModel
import com.example.task.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEmpty

class UserRepositoryImpl(private val userDao: UserDao) : UserRepository {
    override suspend fun insertUser(user: UserDomainModel) {
        userDao.insertUser(user.toNoteEntityModel())
    }

    override fun getAllUser(): Flow<List<UserDomainModel>> =
        userDao.getAllUsers().map { list ->
            list.map { userEntity -> userEntity.toUserDomainModel() }
        }.onEmpty {
            return@onEmpty
        }


}