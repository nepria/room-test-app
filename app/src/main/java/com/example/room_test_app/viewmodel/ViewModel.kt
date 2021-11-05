package com.example.room_test_app.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.room_test_app.data.UserDatabase
import com.example.room_test_app.model.User
import com.example.room_test_app.repository.UserRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(application: Application): AndroidViewModel(application) {
    val readAllData : LiveData<List<User>>
    private val repository : UserRepo

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepo(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(user)
        }
    }
    
}

