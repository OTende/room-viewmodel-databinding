package com.example.roomwiththeview.ui.main

import androidx.lifecycle.*
import com.example.roomwiththeview.model.Task
import com.example.roomwiththeview.model.TaskDAO
import kotlinx.coroutines.launch

class MainViewModel(private val dao: TaskDAO) : ViewModel() {
    val tasks = dao.getAll()

    fun addTask(name: String) {
        val task = Task(taskName = name)
        viewModelScope.launch {
            dao.insert(task)
        }
    }

    class Factory(private val dao: TaskDAO) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(dao) as T
        }
    }
}