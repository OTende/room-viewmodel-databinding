package com.example.roomwiththeview.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.roomwiththeview.R
import com.example.roomwiththeview.databinding.FragmentTaskEditBinding
import com.example.roomwiththeview.databinding.TaskItemBinding
import com.example.roomwiththeview.model.Task
import com.example.roomwiththeview.model.TaskDAO
import com.example.roomwiththeview.model.TaskDatabase

class TaskEditFragment : Fragment() {
    private val taskId by lazy { requireArguments().getLong(NAVIGATION_KEY) }

    private val viewModel: TaskEditViewModel by viewModels {
        TaskEditViewModel.Factory(taskId, TaskDatabase.getDatabase(requireContext()).taskDAO())
    }

    private var _binding: FragmentTaskEditBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskEditBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val NAVIGATION_KEY = "TaskEditFragment.Navigation"
    }
}