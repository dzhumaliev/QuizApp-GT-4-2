package com.geektech.quizapp_gt_4_2.quiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.quizapp_gt_4_2.R;
import com.geektech.quizapp_gt_4_2.model.Category;
import com.geektech.quizapp_gt_4_2.quiz.recycler.QuizAdapter;
import com.geektech.quizapp_gt_4_2.quiz.recycler.QuizViewHolder;
import com.geektech.quizapp_gt_4_2.result.ResultActivity;
import com.geektech.quizapp_gt_4_2.utils.App;
import com.geektech.quizapp_gt_4_2.ux.data.remote.IQuizApiClient;

import java.util.List;

public class QuizActivity extends AppCompatActivity
        implements QuizViewHolder.Listener {

    //region Static

    private RecyclerView recyclerView;
    private QuizViewModel quizViewModel;
    private TextView textCategory;
    private TextView textAmoung;
    private QuizAdapter adapter;
    private Button img;
    private Button button;
    private ProgressBar progressBar;
    private int category;
    private int amount;
    private String difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        img = findViewById(R.id.img_back);
        category = getIntent().getIntExtra("niceCategory", 0) - 1;
        amount = getIntent().getIntExtra("textAmoung", 0);
        difficulty = getIntent().getStringExtra("niceDifficulty");
        textCategory = findViewById(R.id.text_difficult);
        button = findViewById(R.id.btn_skip);
        textAmoung = findViewById(R.id.tv_amoung);
        progressBar = findViewById(R.id.progress_bar);
        recyclerView = findViewById(R.id.recycler_view);
        onClickImage();

        quizViewModel = ViewModelProviders.of(this).get(QuizViewModel.class);

        quizViewModel.currentPosition.observe(this, integer -> {
            recyclerView.smoothScrollToPosition(integer);
            progressBar.setMax(amount);
            progressBar.setProgress(integer);
            textAmoung.setText(integer.toString() + "/" + amount);
            if (integer > amount) {
                startActivity(new Intent(getApplicationContext(), ResultActivity.class));
            }
        });

        quizViewModel.getQuestions(amount, category + 9, difficulty);
        showData();
        categories();
        initRecycler();
    }

    @SuppressLint("ClickableViewAccessibility")
    public void initRecycler() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        adapter = new QuizAdapter(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setOnTouchListener((v, event) -> true);
    }

    public void categories() {
        App.quizApiClient.getCategory(new IQuizApiClient.CategoryCallback() {
            @Override
            public void onSuccess(List<Category> questions) {
                textCategory.setText(questions.get(category).getName());

            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

    private void showData() {
        quizViewModel.questions.observe(this, question -> {
            adapter.setQuestions(question);
            adapter.upData(question);
        });
    }

    public void onClick(View view) {
        quizViewModel.onSkip();
    }

    public void onClickImage() {
        img.setOnClickListener(v -> quizViewModel.getMinus());
    }

    @Override
    public void onAnswerClick(int position, int selectedAnswerPosition) {
        quizViewModel.onAnswerClick(position, selectedAnswerPosition);
        quizViewModel.finishQuiz.observe(this, integer -> startActivity(new Intent(getApplicationContext(), ResultActivity.class)));
    }
}
