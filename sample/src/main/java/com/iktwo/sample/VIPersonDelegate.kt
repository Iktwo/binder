package com.iktwo.sample

import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.ViewGroup

import com.iktwo.binder.BindingViewHolder
import com.iktwo.binder.ViewDelegate
import com.iktwo.sample.databinding.DelegateVipBinding

class VIPersonDelegate(private val handler: PersonDelegateHandler) : ViewDelegate<BindingViewHolder<DelegateVipBinding>>() {

    override val itemViewType: Int
        get() = 1

    override fun onCreateViewHolder(viewGroup: ViewGroup): BindingViewHolder<DelegateVipBinding> {
        val binding = DataBindingUtil.inflate<DelegateVipBinding>(LayoutInflater.from(viewGroup.context),
                R.layout.delegate_vip, viewGroup, false)

        return BindingViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: BindingViewHolder<DelegateVipBinding>, item: Any, position: Int) {
        viewHolder.binding.model = item as Person
        viewHolder.binding.executePendingBindings()
    }

    override fun canHandleItemTypeAtPosition(item: Any, position: Int): Boolean {
        return (item as? Person)?.isVI ?: false

    }
}
