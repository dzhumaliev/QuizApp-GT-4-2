package com.geektech.quizapp_gt_4_2.quiz;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.geektech.quizapp_gt_4_2.App;
import com.geektech.quizapp_gt_4_2.data.remote.IQuizApiClient;
import com.geektech.quizapp_gt_4_2.model.Question;

import java.util.List;

public class QuizViewModel extends ViewModel {

    private IQuizApiClient quizApiClient = App.quizApiClient;

    MutableLiveData<List<Question>> questions = new MutableLiveData<>();


    public void init(int amount, Integer category, String difficulty) {


    }

}
