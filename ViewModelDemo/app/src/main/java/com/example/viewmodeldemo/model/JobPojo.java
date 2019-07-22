package com.example.viewmodeldemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobPojo
{
    @Expose
    @SerializedName("company_logo")
    public String companyLogo;
    @Expose
    @SerializedName("how_to_apply")
    public String howToApply;
    @Expose
    @SerializedName("description")
    public String description;
    @Expose
    @SerializedName("title")
    public String title;
    @Expose
    @SerializedName("location")
    public String location;
    @Expose
    @SerializedName("company_url")
    public String companyUrl;
    @Expose
    @SerializedName("company")
    public String company;
    @Expose
    @SerializedName("created_at")
    public String createdAt;
    @Expose
    @SerializedName("url")
    public String url;
    @Expose
    @SerializedName("type")
    public String type;
    @Expose
    @SerializedName("id")
    public String id;
}
