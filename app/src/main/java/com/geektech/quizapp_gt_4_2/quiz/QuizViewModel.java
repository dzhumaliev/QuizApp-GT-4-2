package com.geektech.quizapp_gt_4_2.quiz;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.geektech.quizapp_gt_4_2.App;
import com.geektech.quizapp_gt_4_2.data.remote.IQuizApiClient;
import com.geektech.quizapp_gt_4_2.model.Question;

import java.util.List;

public class QuizViewModel extends ViewModel {

    private IQuizApiClient quizApiClient = App.quizApiClient;
    private List<Question> mQuestions;

    MutableLiveData<List<Question>> questions = new MutableLiveData<>();
    MutableLiveData<Integer> currentQuestionPosition = new MutableLiveData<>();

    void init(int amount, Integer category, String difficulty) {
        quizApiClient.getQuestions(new IQuizApiClient.QuestionsCallback() {
            @Override
            public void onSuccess(List<Question> result) {
                mQuestions = result;
                questions.setValue(mQuestions);
                currentQuestionPosition.setValue(0);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

    private int getCorrectAnswersAmount() {
        //TODO:
        return 0;
    }

    void finishQuiz() {
        //TODO:
    }

    void onBackPressed() {
        //TODO:
    }

    void onSkipClick() {
        //TODO:
    }

    void onAnswerClick(int position, int selectedAnswerPosition) {
        // 20, 19
        // 20, 20
        // 20, 21
        // 20, -1

        if (mQuestions.size() > position && position >= 0) {
            mQuestions.get(position).setSelectedAnswerPosition(selectedAnswerPosition);
            questions.setValue(mQuestions);

            // 20, 17 -> 18
            // 20, 18 -> 19
            // 20, 19 -> 20
            // 20, 20

            if (position + 1 == mQuestions.size()) {
                //TODO: Finish quiz
            } else {
                currentQuestionPosition.setValue(position + 1);
            }
        }
    }
}
