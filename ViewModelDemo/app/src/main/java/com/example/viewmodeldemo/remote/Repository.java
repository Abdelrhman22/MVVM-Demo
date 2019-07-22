package com.example.viewmodeldemo.remote;

import android.arch.lifecycle.MutableLiveData;

import com.example.viewmodeldemo.model.JobPojo;
import com.example.viewmodeldemo.services.GitHubService;

import java.util.List;

public class Repository {

    private GitHubService gitHubService;
    private static Repository repository;
    public static Repository getInstance(){
        if (repository == null)
        {
            repository = new Repository();
        }
        return repository;
    }
    private Repository()
    {
        gitHubService = new GitHubService();
    }
    public  MutableLiveData<List<JobPojo>> getJobs(String description,String location)
    {
        return gitHubService.getJobs(description,location);
    }
}
