package com.example.roomwiththeview.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

// Набор функций

@Dao
interface TaskDAO {
    @Insert
    suspend fun insert(task: Task)

    @Insert
    suspend fun insertAll(tasks: List<Task>)

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Query("SELECT * FROM task_table WHERE task_id = :thisTaskId")
    fun get(thisTaskId: Long): LiveData<Task>

    @Query("select * from task_table order by task_id desc")
    fun getAll(): LiveData<List<Task>>
}