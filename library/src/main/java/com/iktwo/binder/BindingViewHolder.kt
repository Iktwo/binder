package com.iktwo.binder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BindingViewHolder<T : ViewDataBinding>(val binding: T) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root)
