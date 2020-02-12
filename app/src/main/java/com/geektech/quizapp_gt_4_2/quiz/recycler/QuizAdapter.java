package com.geektech.quizapp_gt_4_2.quiz.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.quizapp_gt_4_2.R;
import com.geektech.quizapp_gt_4_2.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuizAdapter extends RecyclerView.Adapter<QuizViewHolder> {

    private List<Question> list = new ArrayList<>();

    private List<Question> question = new ArrayList<>();
    private QuizViewHolder.Listener listener;

    public QuizAdapter(QuizViewHolder.Listener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question, parent, false);
        return new QuizViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {
        holder.Question(question.get(position));
    }

    @Override
    public int getItemCount() {
        return question.size();
    }

    public void upData(List<Question> list) {
        this.question = list;
        notifyDataSetChanged();
    }

    public void setQuestions(List<Question> question) {
        this.list.clear();
        this.list.addAll(question);
        notifyDataSetChanged();
    }

}
