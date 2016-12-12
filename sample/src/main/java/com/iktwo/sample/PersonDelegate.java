package com.iktwo.sample;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.iktwo.binder.BindingViewHolder;
import com.iktwo.binder.ViewDelegate;
import com.iktwo.sample.databinding.DelegatePersonBinding;

public class PersonDelegate extends ViewDelegate<BindingViewHolder<DelegatePersonBinding>> {
    private PersonDelegateHandler handler;

    public PersonDelegate(PersonDelegateHandler handler) {
        this.handler = handler;
    }

    @Override
    public int getItemViewType() {
        return 0;
    }

    @Override
    public BindingViewHolder<DelegatePersonBinding> onCreateViewHolder(ViewGroup viewGroup) {
        DelegatePersonBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                R.layout.delegate_person, viewGroup, false);

        binding.setHandler(handler);
        return new BindingViewHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder<DelegatePersonBinding> viewHolder, Object item, int position) {
        viewHolder.binding.setModel((Person) item);
        viewHolder.binding.executePendingBindings();
    }

    @Override
    public boolean canHandleItemTypeAtPosition(Object item, int position) {
        return item instanceof Person;
    }
}
