package com.example.room_test_app.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.room_test_app.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addData(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData():LiveData<List<User>>

    @Update
    suspend fun updateUser(user : User)
}