package com.iktwo.binder

class ListDelegateAdapter<T : Any>(items: List<T> = emptyList()) : DelegateAdapter() {
    private var items: List<T>? = items

    fun setItems(items: List<T>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Any {
        return items!![position]
    }

    override fun getItemCount(): Int {
        return items!!.size
    }
}
