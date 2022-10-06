package com.example.roomwiththeview.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.roomwiththeview.databinding.FragmentMainBinding
import com.example.roomwiththeview.model.TaskDAO
import com.example.roomwiththeview.model.TaskDatabase

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding
        get() = _binding!!

    private val dao by lazy {
        TaskDatabase.getDatabase(requireContext()).taskDAO()
    }

    private val viewModel: MainViewModel by viewModels {
        MainViewModel.Factory(dao)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater)
        val view = binding.root

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.saveTaskButton.setOnClickListener {
            viewModel.addTask(binding.taskEditText.text.toString())
        }

        return view
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}