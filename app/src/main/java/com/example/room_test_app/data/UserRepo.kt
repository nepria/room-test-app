package com.example.room_test_app.data

import androidx.lifecycle.LiveData

class UserRepo(private val userDao : UserDao) {
    val readAllData: LiveData<List<User>> = userDao.readAllData()

     suspend fun addUser(user:User){
        userDao.addData(user)
    }
}