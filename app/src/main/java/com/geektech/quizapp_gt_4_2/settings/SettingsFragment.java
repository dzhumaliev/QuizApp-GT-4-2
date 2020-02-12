package com.geektech.quizapp_gt_4_2.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.geektech.quizapp_gt_4_2.R;
import com.geektech.quizapp_gt_4_2.main.MainViewModel;

public class SettingsFragment extends Fragment {

    private SettingsViewModel mViewModel;
    private MainViewModel mViewModel1;
    private TextView textView;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(SettingsViewModel.class);
        mViewModel1 = ViewModelProviders.of(this).get(MainViewModel.class);

        mViewModel.button1.observe(this, integer -> textView.setText(integer.toString()));
        mViewModel.button1.observe(this, integer -> textView.setText(integer.toString()));
    }

}
