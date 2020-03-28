
package com.seniorsteps.seniorsurvey.API.Responses.EntitiesResponse;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Course {

    @SerializedName("category_id")
    private String mCategoryId;
    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("id")
    private Long mId;
    @SerializedName("image")
    private Object mImage;
    @SerializedName("name")
    private String mName;
    @SerializedName("updated_at")
    private String mUpdatedAt;
    @SerializedName("vendor_id")
    private String mVendorId;
    @SerializedName("youtube_url")
    private String mYoutubeUrl;

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

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Object getImage() {
        return mImage;
    }

    public void setImage(Object image) {
        mImage = image;
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

    public String getVendorId() {
        return mVendorId;
    }

    public void setVendorId(String vendorId) {
        mVendorId = vendorId;
    }

    public String getYoutubeUrl() {
        return mYoutubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        mYoutubeUrl = youtubeUrl;
    }

}
