package com.seniorsteps.seniorsurvey;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.seniorsteps.seniorsurvey.API.ApiManager;
import com.seniorsteps.seniorsurvey.API.Requests.SurveyRequestParameter;
import com.seniorsteps.seniorsurvey.API.Responses.QuestionsResponse.Question;
import com.seniorsteps.seniorsurvey.API.Responses.QuestionsResponse.QuestionsResponse;
import com.seniorsteps.seniorsurvey.API.Responses.QuestionsResponse.QuestionCategory;
import com.seniorsteps.seniorsurvey.API.Responses.SubmitSurveyResponse;
import com.seniorsteps.seniorsurvey.Adapters.QuestionsRecyclerAdapter;
import com.seniorsteps.seniorsurvey.Base.MyBaseActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SurveyQuestions extends MyBaseActivity {


    RecyclerView recyclerView;
    QuestionsRecyclerAdapter adapter;
    public static String CourseId;
    Button submit;
    EditText opinion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_questions);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new QuestionsRecyclerAdapter(null);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        LoadQuestions();

        submit= findViewById(R.id.submit);
        opinion = findViewById(R.id.opinion);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adapter.AnsweredAllQuestions()){
                    submitSurvey();
                }else {
                    ShowMessage(getString(R.string.error),getString(R.string.please_answer_all_questions));
                }
            }
        });

    }

    private void submitSurvey() {

        //prepare data
         String visitorName= getIntent().getStringExtra("name");
        String visitorgender= getIntent().getStringExtra("gender");
        String visitorphone= getIntent().getStringExtra("phone");

        SurveyRequestParameter data = adapter.PrepareData();
        data.setOpinion( opinion.getText().toString());
        Log.e("data",data.toString());
        Log.e("dataJson",new Gson().toJson(data));

        ShowProgressBar();
        ApiManager.getAPIs().SubmitSurvey(DataHolder.moderator.getId()+"",DataHolder.password,
                CourseId,visitorName,visitorphone,visitorgender,
                data)
                .enqueue(new Callback<SubmitSurveyResponse>() {
                    @Override
                    public void onResponse(Call<SubmitSurveyResponse> call, Response<SubmitSurveyResponse> response) {
                        HideProgressBar();
                        if("success".equals(response.body().getStatus())){
                            ShowMessage(getString(R.string.success),getString(R.string.survey_submited_successfuly));
                            finish();
                        }else {
                            ShowMessage(response.body().getStatus(),response.body().getMessage());

                        }
                    }

                    @Override
                    public void onFailure(Call<SubmitSurveyResponse> call, Throwable t) {
                        HideProgressBar();
                        ShowMessage(getString(R.string.error),t.getLocalizedMessage());

                    }
                });
    }

    private void LoadQuestions() {
        ShowProgressBar();
        ApiManager.getAPIs()
                .Quesitons(DataHolder.moderator.getId()+""
                        ,DataHolder.password,CourseId)
                .enqueue(new Callback<QuestionsResponse>() {
                    @Override
                    public void onResponse(Call<QuestionsResponse> call,
                                           Response<QuestionsResponse> response) {
                        HideProgressBar();
                        if(response.body().getStatus().equals("success")){
                            SetAdapterdata(response.body().getData());
                        }else {
                            ShowMessage(getString(R.string.error),"error with webservice");
                        }
                    }

                    @Override
                    public void onFailure(Call<QuestionsResponse> call, Throwable t) {
                        HideProgressBar();
                        ShowMessage(getString(R.string.error),t.getLocalizedMessage());

                    }
                });


    }

    public void SetAdapterdata(List<QuestionCategory> categories){

        List<Question> questions = new ArrayList<>();
        for(QuestionCategory category: categories){
            questions.addAll(category.getQuestions());
        }
        adapter.SetData(questions);

    }

}
