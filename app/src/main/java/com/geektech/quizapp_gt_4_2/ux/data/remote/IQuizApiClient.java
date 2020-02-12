package com.geektech.quizapp_gt_4_2.ux.data.remote;

import androidx.lifecycle.MutableLiveData;

import com.geektech.quizapp_gt_4_2.model.Category;
import com.geektech.quizapp_gt_4_2.model.Global;
import com.geektech.quizapp_gt_4_2.model.Question;


import java.util.List;

public interface IQuizApiClient {
    MutableLiveData<Question> getQuestions(int amount, int category, String difficulty, QuestionsCallback callback);
    MutableLiveData<Category> getCategory(CategoryCallback callback);
    MutableLiveData<Global> getGlobal(GlobalCallback callback);

    void getQuestions(QuestionsCallback callback);

    public interface QuestionsCallback extends GenericCallBack<List<Question>> {

    }

    public interface CategoryCallback extends GenericCallBack<List<Category>> {

    }

    public interface GlobalCallback extends GenericCallBack<List<Global>> {

    }
}
