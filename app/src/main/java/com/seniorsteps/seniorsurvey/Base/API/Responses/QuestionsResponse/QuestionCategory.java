
package com.seniorsteps.seniorsurvey.API.Responses.QuestionsResponse;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class QuestionCategory {

    @SerializedName("questions")
    private List<Question> mQuestions;
    @SerializedName("title")
    private String mTitle;

    public List<Question> getQuestions() {
        return mQuestions;
    }

    public void setQuestions(List<Question> questions) {
        mQuestions = questions;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
