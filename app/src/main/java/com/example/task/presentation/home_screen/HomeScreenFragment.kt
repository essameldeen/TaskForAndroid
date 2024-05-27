package com.example.task.presentation.home_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.task.R
import com.example.task.databinding.FragmentHomeScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeScreenFragment : Fragment() {
    private lateinit var _binding: FragmentHomeScreenBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeScreenBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initListener()
        with(_binding) {
            lifecycleScope.launch {
                viewModel.validationState.collect { state ->
                    when (state) {
                        is ValidationState.InvalidName -> {
                            etName.error = "Invalid name"
                        }

                        is ValidationState.InvalidAge -> {
                            etAge.error = "Invalid age"
                        }

                        is ValidationState.InvalidJobTitle -> {
                            etJobTitle.error = "Invalid job title"
                        }

                        is ValidationState.InvalidGender -> {
                            etGender.error = "Invalid gender"
                        }

                        is ValidationState.Success -> {
                            etName.text.clear()
                            etAge.text.clear()
                            etJobTitle.text.clear()
                            etGender.text.clear()
                            navigateToGetAllUsersFragment()
                        }

                        else -> {}
                    }
                }
            }
        }


    }

    private fun initListener() {
        with(_binding) {
            btnSave.setOnClickListener {
                val name = etName.text.toString()
                val age = etAge.text.toString()
                val jobTitle = etJobTitle.text.toString()
                val gender = etGender.text.toString()
                viewModel.insertUser(name, age, jobTitle, gender)
            }

            btnNavigate.setOnClickListener{
                navigateToGetAllUsersFragment()
            }
        }


    }


    private fun navigateToGetAllUsersFragment() {
        findNavController().navigate(R.id.action_homsSecreen_to_allUser)
    }
}