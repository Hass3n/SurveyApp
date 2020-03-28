package com.seniorsteps.seniorsurvey;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.seniorsteps.seniorsurvey.API.ApiManager;
import com.seniorsteps.seniorsurvey.API.Responses.LoginResponse.LoginResponse;
import com.seniorsteps.seniorsurvey.Base.MyBaseActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Splash extends MyBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String username=getString("username");
                final String password=getString("password");
               if(username==null){
                   startActivity(new Intent(activity,Login.class));
                   finish();
               }else {
                   ApiManager.getAPIs().Login(username,password)
                           .enqueue(new Callback<LoginResponse>() {
                               @Override
                               public void onResponse(Call<LoginResponse> call,
                                                      Response<LoginResponse> response) {
                                   DataHolder.moderator = response.body().getData();
                                   DataHolder.password = password;
                                   startActivity(new Intent(activity,CoursesList.class));
                                   finish();
                               }

                               @Override
                               public void onFailure(Call<LoginResponse> call, Throwable t) {
                                   startActivity(new Intent(activity,Login.class));
                                   finish();

                               }
                           });
               }
            }
        },2000);

    }
}
