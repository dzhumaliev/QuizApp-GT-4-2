package com.geektech.quizapp_gt_4_2.main;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.View;

import com.geektech.quizapp_gt_4_2.R;
import com.geektech.quizapp_gt_4_2.core.CoreFragment;

public class MainFragment extends CoreFragment {

    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.main_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(this)
                .get(MainViewModel.class);
    }

}
