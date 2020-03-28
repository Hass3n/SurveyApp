
package com.seniorsteps.seniorsurvey.API.Responses.QuestionsResponse;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Question {

    @SerializedName("answer1")
    private String mAnswer1;
    @SerializedName("answer2")
    private String mAnswer2;
    @SerializedName("answer3")
    private String mAnswer3;
    @SerializedName("answer4")
    private String mAnswer4;
    @SerializedName("category_id")
    private String mCategoryId;
    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("entity_id")
    private String mEntityId;
    @SerializedName("id")
    private int mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("updated_at")
    private String mUpdatedAt;

    public String getAnswer1() {
        return mAnswer1;
    }

    public void setAnswer1(String answer1) {
        mAnswer1 = answer1;
    }

    public String getAnswer2() {
        return mAnswer2;
    }

    public void setAnswer2(String answer2) {
        mAnswer2 = answer2;
    }

    public String getAnswer3() {
        return mAnswer3;
    }

    public void setAnswer3(String answer3) {
        mAnswer3 = answer3;
    }

    public String getAnswer4() {
        return mAnswer4;
    }

    public void setAnswer4(String answer4) {
        mAnswer4 = answer4;
    }

    public String getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(String categoryId) {
        mCategoryId = categoryId;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getEntityId() {
        return mEntityId;
    }

    public void setEntityId(String entityId) {
        mEntityId = entityId;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        mUpdatedAt = updatedAt;
    }

}
