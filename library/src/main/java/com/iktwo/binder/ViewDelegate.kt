package com.iktwo.binder

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

abstract class ViewDelegate<V : RecyclerView.ViewHolder> {
    abstract val itemViewType: Int

    abstract fun onCreateViewHolder(viewGroup: ViewGroup): V

    abstract fun onBindViewHolder(viewHolder: V, item: Any, position: Int)

    abstract fun canHandleItemTypeAtPosition(item: Any, position: Int): Boolean
}