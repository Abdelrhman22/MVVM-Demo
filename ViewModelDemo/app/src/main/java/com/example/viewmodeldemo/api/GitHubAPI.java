package com.example.viewmodeldemo.api;

import com.example.viewmodeldemo.model.JobPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GitHubAPI
{
    @GET("positions.json")
    Call<List<JobPojo>> getjobs (@Query("description") String description , @Query("location") String location);
}

