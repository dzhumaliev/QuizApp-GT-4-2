package com.geektech.quizapp_gt_4_2.settings;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SettingsViewModel extends ViewModel {
    MutableLiveData<Integer> button1 = new MutableLiveData<>();
    private int count1 = 0;

    public void plus() {
        count1++;
        button1.postValue(count1);
    }

    public void minus() {
        count1--;
        button1.postValue(count1);
    }
}
