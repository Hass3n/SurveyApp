package com.seniorsteps.seniorsurvey.API.Responses;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 11/17/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */
public class SubmitSurveyResponse {
    String status;
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
