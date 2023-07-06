package com.example.doctormobile.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.doctormobile.activities.AllDoctorsActivity
import com.example.doctormobile.databinding.FragmentProfileBinding
import com.example.doctormobile.databinding.RecyclerCategoryItemBinding
import com.example.doctormobile.databinding.RecyclerDoctorBinding
import com.example.doctormobile.model.Category
import com.example.doctormobile.model.Doctor

class CategoryRVAdapter(): RecyclerView.Adapter<CategoryRVAdapter.CategoryViewHolder>() {
    var category: List<Category>? = null

    class CategoryViewHolder(val binding: RecyclerCategoryItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category?) {
            binding.category = category
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val holder = CategoryRVAdapter.CategoryViewHolder(RecyclerCategoryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

        holder.binding.btnCategory.setOnClickListener {
            val intent = Intent(parent.context,AllDoctorsActivity::class.java)
            val doctors: ArrayList<Doctor>? = category?.get(holder.adapterPosition)?.doctors as ArrayList<Doctor>?
            if ( doctors != null) {
                intent.putExtra("doctors",doctors)
                parent.context.startActivity(intent)
            }
        }
        return holder
    }

    override fun getItemCount(): Int {
        return category?.size ?: 0
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(category?.get(position))
    }


    fun submitList(category: List<Category>?) {
        this.category = category
        notifyDataSetChanged()
    }

}