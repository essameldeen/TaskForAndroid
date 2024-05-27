package com.example.task.presentation.all_user_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.example.task.R
import com.example.task.databinding.FragmentAllUserBinding
import com.example.task.presentation.all_user_screen.adapter.UserAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AllUserFragment : Fragment() {
    private lateinit var onBackPressedCallback: OnBackPressedCallback

    private lateinit var _binding: FragmentAllUserBinding
    private val viewModel: AllUserViewModel by viewModels()
    override fun onStart() {
        super.onStart()
        onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val navController = NavHostFragment.findNavController(this@AllUserFragment)
                navController.popBackStack()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllUserBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = UserAdapter()
        with(_binding) {
            rvAllUser.adapter = adapter
        }

        lifecycleScope.launch {
            viewModel.getAllUsers().collect { users ->
                adapter.submitList(users)
            }
        }


    }

    override fun onStop() {
        super.onStop()
        onBackPressedCallback.remove()
    }

}