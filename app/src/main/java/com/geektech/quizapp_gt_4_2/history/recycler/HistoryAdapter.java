package com.geektech.quizapp_gt_4_2.history.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.quizapp_gt_4_2.R;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryViewHolder> {
    private HistoryViewHolder viewHolder;

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history_recycler_view, parent, false);
        return new HistoryViewHolder(view, viewHolder);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
