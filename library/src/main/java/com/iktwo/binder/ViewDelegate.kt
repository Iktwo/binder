package com.iktwo.binder

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup

abstract class ViewDelegate<V : androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    abstract val itemViewType: Int

    abstract fun onCreateViewHolder(viewGroup: ViewGroup): V

    abstract fun onBindViewHolder(viewHolder: V, item: Any, position: Int)

    abstract fun canHandleItemTypeAtPosition(item: Any, position: Int): Boolean
}