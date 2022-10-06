package com.example.roomwiththeview.ui.main

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.roomwiththeview.model.Task
import com.example.roomwiththeview.model.TaskDAO
import kotlinx.coroutines.launch

// ViewModel

class MainViewModel(private val dao: TaskDAO) : ViewModel() {
    private val tasks = dao.getAll()

    val tasksString = Transformations.map(tasks) {
        it.joinToString(postfix = "\n")
    }

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