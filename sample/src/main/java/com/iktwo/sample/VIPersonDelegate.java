package com.iktwo.sample;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.iktwo.binder.BindingViewHolder;
import com.iktwo.binder.ViewDelegate;
import com.iktwo.sample.databinding.DelegateVipBinding;

public class VIPersonDelegate extends ViewDelegate<BindingViewHolder<DelegateVipBinding>> {


    public VIPersonDelegate() {

    }

    @Override
    public int getItemViewType() {
        return 1;
    }

    @Override
    public BindingViewHolder<DelegateVipBinding> onCreateViewHolder(ViewGroup viewGroup) {
        DelegateVipBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                R.layout.delegate_vip, viewGroup, false);

        return new BindingViewHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder<DelegateVipBinding> viewHolder, Object item, int position) {
        viewHolder.getBinding().setModel((Person) item);
        viewHolder.getBinding().executePendingBindings();
    }

    @Override
    public boolean canHandleItemTypeAtPosition(@NonNull Object item, int position) {
        if (item instanceof Person) {
            return ((Person) item).isVI;
        }

        return false;
    }
}