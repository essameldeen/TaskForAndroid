package com.example.task.di

import android.content.Context
import androidx.room.Room
import com.example.task.data.dataBase.UserDao
import com.example.task.data.dataBase.UserDataBase
import com.example.task.data.repository.UserRepositoryImpl
import com.example.task.domain.repository.UserRepository
import com.example.task.domain.usecase.GetAllUserUseCase
import com.example.task.domain.usecase.InsertUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, UserDataBase::class.java, "user.db"
    ).build()

    @Provides
    @Singleton
    fun provideUserDao(db: UserDataBase) = db.userDao()

    @Provides
    @Singleton
    fun provideUserRepository(
        userDao: UserDao
    ): UserRepository {
        return UserRepositoryImpl(userDao = userDao)
    }

    @Provides
    fun provideInsertNoteUseCase(userRepository: UserRepository): InsertUserUseCase {
        return InsertUserUseCase(userRepository)
    }

    @Provides
    fun provideGetAllUsersUseCase(userRepository: UserRepository): GetAllUserUseCase {
        return GetAllUserUseCase(userRepository)
    }

}