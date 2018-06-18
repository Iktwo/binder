package com.iktwo.sample

import androidx.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.ViewGroup

import com.iktwo.binder.BindingViewHolder
import com.iktwo.binder.ViewDelegate
import com.iktwo.sample.databinding.DelegatePersonBinding

class PersonDelegate(private val handler: PersonDelegateHandler) : ViewDelegate<BindingViewHolder<DelegatePersonBinding>>() {

    override val itemViewType: Int
        get() = 0

    override fun onCreateViewHolder(viewGroup: ViewGroup): BindingViewHolder<DelegatePersonBinding> {
        val binding = DataBindingUtil.inflate<DelegatePersonBinding>(LayoutInflater.from(viewGroup.context),
                R.layout.delegate_person, viewGroup, false)

        binding.handler = handler
        return BindingViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: BindingViewHolder<DelegatePersonBinding>, item: Any, position: Int) {
        viewHolder.binding.model = item as Person
        viewHolder.binding.executePendingBindings()
    }

    override fun canHandleItemTypeAtPosition(item: Any, position: Int): Boolean {
        return if (item is Person) {
            !item.isVI
        } else false

    }
}
