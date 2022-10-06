package com.example.roomwiththeview.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// База данных

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDAO(): TaskDAO

    companion object {
        var INSTANCE: TaskDatabase? = null

        fun getDatabase(context: Context): TaskDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    TaskDatabase::class.java,
                    "TaskDatabase"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}