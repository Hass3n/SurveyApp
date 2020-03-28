package com.seniorsteps.seniorsurvey.API;


import com.seniorsteps.seniorsurvey.API.Requests.SurveyRequestParameter;
import com.seniorsteps.seniorsurvey.API.Responses.EntitiesResponse.EntitiesResponse;
import com.seniorsteps.seniorsurvey.API.Responses.LoginResponse.LoginResponse;
import com.seniorsteps.seniorsurvey.API.Responses.QuestionsResponse.QuestionsResponse;
import com.seniorsteps.seniorsurvey.API.Responses.SubmitSurveyResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AppServices {


    @POST("login")
    @FormUrlEncoded
    Call<LoginResponse> Login(@Field("user_name") String username,
                              @Field("password") String password);
    @POST("entities")
    @FormUrlEncoded
    Call<EntitiesResponse> Entities(@Field("moderator_id") String moderator_id,
                                    @Field("password") String password);
    @POST("survey/questions")
    @FormUrlEncoded
    Call<QuestionsResponse> Quesitons(@Field("moderator_id") String moderator_id,
                                      @Field("password") String password, @Field("entity_id") String entity_id);

    @POST("survey/add")
    @FormUrlEncoded
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    Call<SubmitSurveyResponse> SubmitSurvey(
            @Field("moderator_id") String moderator_id,
            @Field("password") String password,
            @Field("entity_id") String entity_id,
            @Field("visitor_name") String visitor_name,
            @Field("visitor_mobile") String visitor_mobile,
            @Field("visitor_gender") String visitor_gender,
            @Field("survey") SurveyRequestParameter survey
    );
    /*
    *
    * moderator_id=1&password=123456&entity_id=32&visitor_name=nabil&visitor_mobile=123456&visitor_gender=male&
    *
    * survey=
    * {"opinion":"great event"
    * ,
    * "answers":[{"answer":1,"question_id":9},{"answer":1,"question_id":10},{"answer":1,"question_id":11}]}*/
}
