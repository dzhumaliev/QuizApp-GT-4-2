package com.geektech.quizapp_gt_4_2.quiz;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.geektech.quizapp_gt_4_2.utils.App;
import com.geektech.quizapp_gt_4_2.model.Question;
import com.geektech.quizapp_gt_4_2.ux.data.remote.IQuizApiClient;

import java.util.List;

public class QuizViewModel extends ViewModel {

    MutableLiveData<List<Question>> questions = new MutableLiveData<>();
    private List<Question> mQuestions;
    MutableLiveData<Integer> finishQuiz = new MutableLiveData<>();
    MutableLiveData<Integer> currentPosition = new MutableLiveData<>();
    MutableLiveData<Integer> positionAnswer = new MutableLiveData<>();

    void getQuestions(final int amount, int category, String difficulty) {
        App.quizApiClient.getQuestions(amount, category, difficulty, new IQuizApiClient.QuestionsCallback() {
            @Override
            public void onSuccess(List<Question> question) {
                currentPosition.setValue(0);
                mQuestions = question;
                Log.d("ololo", "onChanged: " + question);
                questions.setValue(question);
            }

            @Override
            public void onFailure(Exception e) {
                e.getMessage();
            }
        });
    }

    public void getMinus() {
        Integer currentPositions = currentPosition.getValue();
        if (positionAnswer != currentPosition) {
            currentPosition.setValue(currentPositions - 1);
        } else {
            return;
        }
    }

    public void onSkip() {
        Integer currentPositions = currentPosition.getValue();
        if (currentPositions != null) {
            currentPosition.setValue(currentPositions + 1);
        }
    }

    private Integer getCorrectAnswersAmount() {
        return 0;

    }

    void onAnswerClick(int position, int selectedAnswerPosition) {
        if (mQuestions.size() > position && position >= 0) {
            mQuestions.get(position).setSelectedAnswerPosition(selectedAnswerPosition);
            questions.setValue(mQuestions);

            if (position + 1 == mQuestions.size()) {
                finishQuiz.setValue(position);
            } else {
                currentPosition.setValue(position + 1);
            }
        }
    }
}