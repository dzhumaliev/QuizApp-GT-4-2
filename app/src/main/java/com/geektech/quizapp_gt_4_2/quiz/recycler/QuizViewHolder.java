package com.geektech.quizapp_gt_4_2.quiz.recycler;

import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.quizapp_gt_4_2.R;
import com.geektech.quizapp_gt_4_2.model.EType;
import com.geektech.quizapp_gt_4_2.model.Question;

public class QuizViewHolder extends RecyclerView.ViewHolder {

    private ConstraintLayout contenerMutable;
    private ConstraintLayout contenerBoolean;
    private TextView quistions;
    private TextView textDifficulty;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btnTrue;
    private Button btnFalse;

    private Button btn_4;
    private Listener listener;


    public QuizViewHolder(@NonNull View itemView, Listener listener) {

        super(itemView);
        this.listener = listener;
        quistions = itemView.findViewById(R.id.quistions);
        contenerBoolean = itemView.findViewById(R.id.contener_true_false);
        contenerMutable = itemView.findViewById(R.id.contener_mutable);
        textDifficulty = itemView.findViewById(R.id.text_difficult);
        btn_1 = itemView.findViewById(R.id.btn_1);
        btn_2 = itemView.findViewById(R.id.btn_2);
        btn_3 = itemView.findViewById(R.id.btn_3);
        btn_4 = itemView.findViewById(R.id.btn_4);
        btnTrue = itemView.findViewById(R.id.btn_true);
        btnFalse = itemView.findViewById(R.id.btn_false);
    }

    void checkButton(Boolean enabled){
        btn_1.setEnabled(enabled);
        btn_2.setEnabled(enabled);
        btn_3.setEnabled(enabled);
        btn_4.setEnabled(enabled);
    }

    void Question(Question question) {
        if (question.getSelectedAnswerPosition() !=null){
            checkButton(false);
        }else {
            checkButton(true);
        }
        quistions.setText(Html.fromHtml(question.getQuestion()));
        if (question.getType().equals(EType.MULTIBLE)) {
            contenerMutable.setVisibility(View.VISIBLE);
            contenerBoolean.setVisibility(View.INVISIBLE);
            btn_1.setText(question.getAnswers().get(0));
            btn_2.setText(question.getAnswers().get(1));
            btn_3.setText(question.getAnswers().get(2));
            btn_4.setText(question.getAnswers().get(3));

            btn_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btn_1.setBackgroundResource(R.color.colorCorrectAnswer);
                    if (question.getIncorrectAnswers() == btn_1.getText()) {
                        btn_1.setBackgroundResource(R.color.colorInCorrectAnswer);
                    }

                    listener.onAnswerClick(getAdapterPosition(), 1);

                }
            });
            btn_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btn_2.setBackgroundResource(R.color.colorCorrectAnswer);

                    if (question.getIncorrectAnswers() == btn_2.getText()) {
                        btn_2.setBackgroundResource(R.color.colorInCorrectAnswer);
                    }
                    listener.onAnswerClick(getAdapterPosition(), 2);

                }
            });
            btn_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btn_3.setBackgroundResource(R.color.colorCorrectAnswer);

                    if (question.getIncorrectAnswers() == btn_3.getText()) {
                        btn_3.setBackgroundResource(R.color.colorInCorrectAnswer);
                    }
                    listener.onAnswerClick(getAdapterPosition(), 3);

                }
            });
            btn_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btn_4.setBackgroundResource(R.color.colorCorrectAnswer);

                    if (question.getIncorrectAnswers() == btn_4.getText()) {
                        btn_4.setBackgroundResource(R.color.colorInCorrectAnswer);
                    }
                    listener.onAnswerClick(getAdapterPosition(), 4);

                }
            });


        } else {
            contenerBoolean.setVisibility(View.VISIBLE);
            contenerMutable.setVisibility(View.INVISIBLE);
            btnTrue.setText(question.getAnswers().get(0));
            btnFalse.setText(question.getAnswers().get(1));

            btnTrue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnFalse.setBackgroundResource(R.color.colorCorrectAnswer);

                    listener.onAnswerClick(getAdapterPosition(), 0);
                }
            });
            btnFalse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnFalse.setBackgroundResource(R.color.colorCorrectAnswer);


                    listener.onAnswerClick(getAdapterPosition(), 1);
                }
            });
        }
    }

    public interface Listener {
        void onAnswerClick(int position, int selectedAnswerPosition);
    }
}
