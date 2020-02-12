package com.geektech.quizapp_gt_4_2.history;

import androidx.lifecycle.ViewModel;

import com.geektech.quizapp_gt_4_2.model.History;

import java.util.List;

public class HistoryViewModel extends ViewModel {
    private List<History> mHistory;
    void onHistoryClick(int position){
        mHistory.get(position);
    }
}
