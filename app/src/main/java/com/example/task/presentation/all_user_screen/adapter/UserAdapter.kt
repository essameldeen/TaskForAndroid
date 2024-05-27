package com.example.task.presentation.all_user_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.task.databinding.UserItemLayoutBinding
import com.example.task.domain.model.UserDomainModel

class UserAdapter : ListAdapter<UserDomainModel, UserAdapter.UserViewHolder>(UserDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserItemLayoutBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }

    inner class UserViewHolder(private val binding: UserItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: UserDomainModel) {
            binding.tvName.text = user.name
            binding.tvAge.text = "Age: ${user.age}"
            binding.tvJobTitle.text = "Job Title: ${user.jobTitle}"
            binding.tvGender.text = "Gender: ${user.gender}"
        }
    }
}

class UserDiffCallback : DiffUtil.ItemCallback<UserDomainModel>() {
    override fun areItemsTheSame(oldItem: UserDomainModel, newItem: UserDomainModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserDomainModel, newItem: UserDomainModel): Boolean {
        return oldItem == newItem
    }
}