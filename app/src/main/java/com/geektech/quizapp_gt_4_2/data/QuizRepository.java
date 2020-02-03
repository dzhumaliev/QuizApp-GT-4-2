package com.geektech.quizapp_gt_4_2.data;

import com.geektech.quizapp_gt_4_2.data.history.IHistoryStorage;
import com.geektech.quizapp_gt_4_2.data.remote.IQuizApiClient;
import com.geektech.quizapp_gt_4_2.model.Question;

import java.util.List;

public class QuizRepository {

    private IQuizApiClient quizApiClient;
    private IHistoryStorage historyStorage;

    public QuizRepository(
            IQuizApiClient client,
            IHistoryStorage storage
    ) {
        quizApiClient = client;
        historyStorage = storage;
    }

    public void getQuestions(final IQuizApiClient.QuestionsCallback callback) {
        quizApiClient.getQuestions(new IQuizApiClient.QuestionsCallback() {
            @Override
            public void onSuccess(List<Question> result) {
                //TODO: Shuffle result answers
                callback.onSuccess(result);
            }

            @Override
            public void onFailure(Exception e) {
                callback.onFailure(e);
            }
        });
    }
}
