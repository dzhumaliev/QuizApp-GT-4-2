package com.geektech.quizapp_gt_4_2.ux.data;

import com.geektech.quizapp_gt_4_2.model.Question;
import com.geektech.quizapp_gt_4_2.ux.data.remote.IQuizApiClient;

import java.util.ArrayList;
import java.util.Collections;

public class QuizReposotory {
    private IQuizApiClient quizApiClient;
    private IHistoryStorage historyStorage;



    public Question shuffleAnswers(Question question) {
        ArrayList<String> answers = new ArrayList<>();
        answers.add(question.getCorrectAnswer());
        answers.addAll(question.getIncorrectAnswers());
        Collections.shuffle(answers);
        question.setAnswers(answers);
        return question;
    }
    }

