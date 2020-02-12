package com.geektech.quizapp_gt_4_2.ux.data.remote;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;


import com.geektech.quizapp_gt_4_2.model.Category;
import com.geektech.quizapp_gt_4_2.model.Global;
import com.geektech.quizapp_gt_4_2.model.Question;
import com.geektech.quizapp_gt_4_2.ux.core.CoreCallBack;
import com.geektech.quizapp_gt_4_2.ux.data.QuizReposotory;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class QuizApiClint implements IQuizApiClient {

    private QuizReposotory quizReposotory = new QuizReposotory();

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://opentdb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private QuizApi client = retrofit.create(QuizApi.class);
    private QuizCategory clientCategory = retrofit.create(QuizCategory.class);


    /*Question shuffleAnswers(Question question) {
        ArrayList<String> answers = new ArrayList<>();
        answers.add(question.getCorrectAnswer());
        answers.addAll(question.getIncorrectAnswers());
        Collections.shuffle(answers);
        question.setAnswers(answers);
        return question;
    }*/
    //region get questions
    @Override
    public MutableLiveData<Question> getQuestions(int amount, int category, String difficulty, final QuestionsCallback callback) {
        final Call<QuizQuestionsResponse> call = client.getQuestions(
                amount,
                category,
                difficulty
        );

        call.enqueue(new CoreCallBack<QuizQuestionsResponse>() {
            @Override
            public void onSuccess(QuizQuestionsResponse result) {
                callback.onSuccess(result.getResults());
                Log.d("ololol", "onSuccess: " + call.request().url());
                for (int i = 0; i < result.getResults().size(); i++) {
                    Question question = result.getResults().get(i);
                    result.getResults().set(i, quizReposotory.shuffleAnswers(question));
                }
            }

            @Override
            public void onFailure(Exception e) {
                callback.onFailure(e);
            }
        });

        return null;
    }

    @Override
    public MutableLiveData<Category> getCategory(final CategoryCallback callback) {
        final Call<QuizCategoryResponse> call = clientCategory.getCategory();
        call.enqueue(new CoreCallBack<QuizCategoryResponse>() {
            @Override
            public void onSuccess(QuizCategoryResponse result) {
                callback.onSuccess(result.getTriviaCategories());
                Log.d("ololol", "onSuccess Category " + call.request().url());

            }

            @Override
            public void onFailure(Exception e) {

            }
        });
        return null;
    }

    @Override
    public MutableLiveData<Global> getGlobal(GlobalCallback callback) {
//        clientGlobal.getGlobal()
        return null;
    }

    @Override
    public void getQuestions(QuestionsCallback callback) {

    }

    private interface QuizApi {
        @GET("api.php")
        Call<QuizQuestionsResponse> getQuestions(
                @Query("amount") int amount,
                @Query("category") int category,
                @Query("difficulty") String difficulty
        );
    }

    private interface QuizCategory {
        @GET("api_category.php")
        Call<QuizCategoryResponse> getCategory();
    }

    private interface QuizGlobal {
        @GET("api_count_global.php")
        Call<GlobalResponse> getGlobal();
    }
}
