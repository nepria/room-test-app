package com.example.room_test_app.repository

import androidx.lifecycle.LiveData
import com.example.room_test_app.model.User
import com.example.room_test_app.data.UserDao

class UserRepo(private val userDao : UserDao) {
    val readAllData: LiveData<List<User>> = userDao.readAllData()

     suspend fun addUser(user: User){
        userDao.addData(user)
    }

    suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }
    
    suspend fun deleteAllUsers(){
        userDao.deleteAllUsers()
    }
}