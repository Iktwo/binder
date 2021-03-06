package com.iktwo.binder

import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.util.SparseArray
import android.view.ViewGroup

abstract class DelegateAdapter : androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>() {
    private val delegates = SparseArray<ViewDelegate<out androidx.recyclerview.widget.RecyclerView.ViewHolder>>()

    fun <T : androidx.recyclerview.widget.RecyclerView.ViewHolder> registerDelegate(delegate: ViewDelegate<T>) {
        val viewType = delegate.itemViewType

        if (delegates[viewType] != null) {
            Log.w(DelegateAdapter::class.java.simpleName, "You are registering a delegate for a ViewType that was already registered.")
        }

        delegates.put(viewType, delegate)
    }

    internal fun getDelegateByViewHolder(viewHolder: androidx.recyclerview.widget.RecyclerView.ViewHolder): ViewDelegate<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
        return viewHolder.itemView.getTag(R.id.delegate) as ViewDelegate<androidx.recyclerview.widget.RecyclerView.ViewHolder>
    }

    internal fun getDelegateByPosition(position: Int): ViewDelegate<out androidx.recyclerview.widget.RecyclerView.ViewHolder>? {
        val item = getItem(position)

        var i = 0
        val size = delegates.size()
        while (item != null && i < size) {
            val delegate = delegates.valueAt(i)

            if (delegate.canHandleItemTypeAtPosition(item, position)) {
                return delegate
            }
            i++
        }

        return null
    }

    internal fun getDelegateByViewType(viewType: Int): ViewDelegate<out androidx.recyclerview.widget.RecyclerView.ViewHolder> {
        return delegates.get(viewType)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): androidx.recyclerview.widget.RecyclerView.ViewHolder {
        val delegate = getDelegateByViewType(viewType)

        val viewHolder = delegate.onCreateViewHolder(viewGroup)
        viewHolder.itemView.setTag(R.id.delegate, delegate)

        return viewHolder
    }

    override fun onBindViewHolder(viewHolder: androidx.recyclerview.widget.RecyclerView.ViewHolder, position: Int) {
        val delegate = getDelegateByViewHolder(viewHolder)
        val item = getItem(position)

        if (item != null) {
            delegate.onBindViewHolder(viewHolder, item, position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getDelegateByPosition(position)!!.itemViewType
    }

    abstract fun getItem(position: Int): Any?
}

