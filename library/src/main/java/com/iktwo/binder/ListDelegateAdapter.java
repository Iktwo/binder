package com.iktwo.binder;

import android.support.annotation.NonNull;

import java.util.Collections;
import java.util.List;

public class ListDelegateAdapter extends DelegateAdapter {
    private List<?> items;

    public ListDelegateAdapter(@NonNull List<?> items) {
        this.items = items;
    }

    public ListDelegateAdapter() {
        this.items = Collections.emptyList();
    }

    public void setItems(List<?> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
