package com.seniorsteps.seniorsurvey;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.seniorsteps.seniorsurvey.API.ApiManager;
import com.seniorsteps.seniorsurvey.API.Responses.EntitiesResponse.Course;
import com.seniorsteps.seniorsurvey.API.Responses.EntitiesResponse.EntitiesResponse;
import com.seniorsteps.seniorsurvey.API.Responses.LoginResponse.LoginResponse;
import com.seniorsteps.seniorsurvey.Adapters.CoursesRecyclerAdapter;
import com.seniorsteps.seniorsurvey.Base.MyBaseActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoursesList extends MyBaseActivity {

    RecyclerView recyclerView;
    CoursesRecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new CoursesRecyclerAdapter(null);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        adapter.setOnItemClickListener(new CoursesRecyclerAdapter.OnItemClick() {
            @Override
            public void onClick(int pos, Course course) {
                SurveyQuestions.CourseId = course.getId()+"";
                YoutubePlayerActivity.course = course;
                startActivity(new Intent(activity,YoutubePlayerActivity.class));
            }
        });
        LoadCourseList();
    }

    private void LoadCourseList() {
        ShowProgressBar();
        ApiManager.getAPIs()
                .Entities(DataHolder.moderator.getId()+"",DataHolder.password)
                .enqueue(new Callback<EntitiesResponse>() {
                    @Override
                    public void onResponse(Call<EntitiesResponse> call,
                                           Response<EntitiesResponse> response) {
                        HideProgressBar();
                        Log.e("resp",response.toString());
                        Log.e("data",response.body().getmStatus());
                        Log.e("data",response.body().getmCourses()+"");
                        if(response.body().getmStatus().equals("success")){
                            SetAdapterData(response.body().getmCourses());

                        }else {
                            ShowMessage(getString(R.string.error),"error with web service");

                        }
                    }

                    @Override
                    public void onFailure(Call<EntitiesResponse> call, Throwable t) {
                        HideProgressBar();
                        ShowMessage(getString(R.string.error),t.getLocalizedMessage());
                    }
                });
    }


    public void SetAdapterData(List<Course> courses){
        adapter.SetData(courses);
    }
}
