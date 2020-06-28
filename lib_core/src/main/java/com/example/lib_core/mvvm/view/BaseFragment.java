package com.example.lib_core.mvvm.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;

//基础的fragment
public abstract class BaseFragment<Binding extends ViewDataBinding,VM extends ViewModel> extends Fragment {

    protected Binding binding;
    protected VM vm;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,getIntlayout(),container,false);

        vm = creatVM();

        view = binding.getRoot();

        return view;
    }

    protected abstract int getIntlayout();

    protected abstract VM creatVM();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
