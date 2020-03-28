package com.seniorsteps.seniorsurvey;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.seniorsteps.seniorsurvey.Base.MyBaseActivity;

public class AddVisitor extends MyBaseActivity {

    private TextInputLayout username;
    private TextInputLayout phone;
    private Spinner gender;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_visitor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Validate()){
                    PrepareData();
                }
            }
        });
    }

    private void PrepareData() {
        String nameString,phoneString;

        nameString = username.getEditText().getText().toString();
        phoneString = phone.getEditText().getText().toString();
        int pos = gender.getSelectedItemPosition();
        String genderString = "male";
        if(pos==1){
            genderString="female";
        }
        Intent intent = new Intent(activity,SurveyQuestions.class);
        intent.putExtra("name",nameString);
        intent.putExtra("phone",phoneString);
        intent.putExtra("gender",genderString);
        startActivity(intent);
        finish();



    }

    public boolean Validate(){
        String nameString,phoneString;

        nameString = username.getEditText().getText().toString();

        if(nameString.equals("")){
            username.setError(getString(R.string.required));
            return false;
        }
        username.setError(null);
        phoneString = phone.getEditText().getText().toString();

        if(phoneString.trim().equals("")){
            phone.setError(getString(R.string.required));
            return false;
        }

        return true;

    }
    private void initView() {
        username = (TextInputLayout) findViewById(R.id.username);
        phone = (TextInputLayout) findViewById(R.id.phone);
        gender = (Spinner) findViewById(R.id.gender);
        next = (Button) findViewById(R.id.next);
    }
}
