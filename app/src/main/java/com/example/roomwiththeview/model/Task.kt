package com.example.roomwiththeview.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Таблица

@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "task_id")
    val taskId: Long = 0L,

    @ColumnInfo(name = "task_name")
    val taskName: String = "",

    @ColumnInfo(name = "task_done")
    val taskDone: Boolean = false
) {

}
