package com.seniorsteps.seniorsurvey;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.seniorsteps.seniorsurvey.API.ApiManager;
import com.seniorsteps.seniorsurvey.API.Responses.LoginResponse.LoginResponse;
import com.seniorsteps.seniorsurvey.Base.MyBaseActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends MyBaseActivity {

    private TextInputLayout userName;
    private TextInputLayout password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameString = userName.getEditText().getText().toString();
                String passwordString = password.getEditText().getText().toString();
                if(Validate(usernameString,passwordString)){
                    login(usernameString,passwordString);
                }

            }
        });
    }

    public void login(final String username, final String password){

        ShowProgressBar();
        ApiManager.getAPIs()
                .Login(username,password)
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        HideProgressBar();
                        if(response.body().getStatus().equals("success")){

                            SaveString("username",username);
                            SaveString("password",password);
                            DataHolder.moderator = response.body().getData();
                            DataHolder.password = password;
                            startActivity(new Intent(activity,CoursesList.class));
                            finish();

                        }else {
                            ShowMessage(getString(R.string.error),getString(R.string.wrong_username_or_password));
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        HideProgressBar();
                        ShowMessage(getString(R.string.error),t.getLocalizedMessage());

                    }
                });
    }

    public boolean Validate(String usernameString,String passwordString){
        if(usernameString.trim().equals("")){
            userName.setError(getString(R.string.required));
            return false;
        }
        userName.setError(null);

       if(passwordString.trim().equals("")){
            password.setError(getString(R.string.required));
            return false;
        }
        if(passwordString.length()<6){
            password.setError(getString(R.string.min_six_chars));
            return false;
        }
        password.setError(null);

       return true;

    }

    private void initView() {
        userName = (TextInputLayout) findViewById(R.id.user_name);
        password = (TextInputLayout) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
    }
}
