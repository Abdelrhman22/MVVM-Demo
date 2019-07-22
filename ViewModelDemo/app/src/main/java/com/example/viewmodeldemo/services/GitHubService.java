package com.example.viewmodeldemo.services;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.viewmodeldemo.model.JobPojo;
import com.example.viewmodeldemo.network.NetworkService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GitHubService
{
    NetworkService networkService;
    public GitHubService()
    {
        networkService = new NetworkService();
    }

    public  MutableLiveData<List<JobPojo>> getJobs(String description,String location)
    {
        final MutableLiveData<List<JobPojo>> jobs = new MutableLiveData<>();
        networkService.getGitHubAPI().getjobs(description,location).enqueue(new Callback<List<JobPojo>>() {
            @Override
            public void onResponse(Call<List<JobPojo>> call, Response<List<JobPojo>> response) {
                if (response.isSuccessful())
                {
                    Log.i("message","response has a value");
                    jobs.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<JobPojo>> call, Throwable t) {
                    jobs.setValue(null);
            }
        });

        return jobs;
    }

}
