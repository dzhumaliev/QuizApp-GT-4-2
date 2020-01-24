package com.geektech.quizapp_gt_4_2.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public MutableLiveData<String> message = new MutableLiveData<>();

    public MutableLiveData<Integer> counter = new MutableLiveData<>();
    private int count = 0;

    public MainViewModel() {
        counter.setValue(0);

        Log.d("ololo", "View model create");

        message.setValue("Hello Observer");
    }

    public void onIncrementClick() {
        count++;
        counter.setValue(count);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

}
