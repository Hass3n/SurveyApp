
package com.seniorsteps.seniorsurvey.API.Responses.EntitiesResponse;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class EntitiesResponse {

    @SerializedName("status")
    private String mStatus;
    @SerializedName("data")
    private List<Course> mCourses;

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public List<Course> getmCourses() {
        return mCourses;
    }

    public void setmCourses(List<Course> mCourses) {
        this.mCourses = mCourses;
    }
}
