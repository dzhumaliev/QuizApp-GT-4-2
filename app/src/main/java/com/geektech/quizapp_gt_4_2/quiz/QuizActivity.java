package com.geektech.quizapp_gt_4_2.quiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class QuizActivity extends AppCompatActivity {

    private static String EXTRA_AMOUNT = "amount";
    private static String EXTRA_CATEGORY = "category";
    private static String EXTRA_DIFFICULTY = "difficulty";

    public static void start(
            Context context,
            Integer amount,
            Integer category,
            String difficulty
    ) {
        Intent intent = new Intent(context, QuizActivity.class);

        intent.putExtra(EXTRA_AMOUNT, amount);
        intent.putExtra(EXTRA_CATEGORY, category);
        intent.putExtra(EXTRA_DIFFICULTY, difficulty);

        context.startActivity(intent);
    }

    private QuizViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = ViewModelProviders.of(this)
                .get(QuizViewModel.class);
    }
}
