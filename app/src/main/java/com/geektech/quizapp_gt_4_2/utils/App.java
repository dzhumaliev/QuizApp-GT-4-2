package com.geektech.quizapp_gt_4_2.utils;

import android.app.Application;

import com.geektech.quizapp_gt_4_2.ux.data.IHistoryStorage;
import com.geektech.quizapp_gt_4_2.ux.data.remote.IQuizApiClient;
import com.geektech.quizapp_gt_4_2.ux.data.remote.QuizApiClint;


public class App extends Application {
    public static IQuizApiClient quizApiClient;
    public static IHistoryStorage historyStorage;

    @Override
    public void onCreate() {
        super.onCreate();
        quizApiClient = new QuizApiClint();
//        historyStorage = new IHistoryStorage();
    }

}
