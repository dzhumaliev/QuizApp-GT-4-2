package com.geektech.quizapp_gt_4_2.ux.data.remote;


import com.geektech.quizapp_gt_4_2.model.Category;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuizCategoryResponse {

    @SerializedName("trivia_categories")
    private List<Category> triviaCategories;

    public List<Category> getTriviaCategories() {
        return triviaCategories;
    }

    public void setTriviaCategories(List<Category> triviaCategories) {
        this.triviaCategories = triviaCategories;
    }
}

