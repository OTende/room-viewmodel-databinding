package com.example.roomwiththeview.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.roomwiththeview.model.TaskDAO
import kotlinx.coroutines.launch

class TaskEditViewModel(taskId: Long, private val dao: TaskDAO) : ViewModel() {
    val task = dao.get(taskId)

    fun updateTask() {
        viewModelScope.launch {
            dao.update(task.value!!)
        }
    }

    fun deleteTask() {
        viewModelScope.launch {
            dao.delete(task.value!!)
        }
    }

    class Factory(private val taskId: Long, private val dao: TaskDAO) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return TaskEditViewModel(taskId, dao) as T
        }
    }
}