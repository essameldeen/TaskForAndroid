package com.example.task.data.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.task.data.model.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class UserDataBase : RoomDatabase(){
    abstract fun userDao(): UserDao

}