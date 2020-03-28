
package com.seniorsteps.seniorsurvey.API.Responses.QuestionsResponse;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class QuestionsResponse {

    @SerializedName("data")
    private List<QuestionCategory> mData;
    @SerializedName("status")
    private String mStatus;

    public List<QuestionCategory> getData() {
        return mData;
    }

    public void setData(List<QuestionCategory> data) {
        mData = data;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
