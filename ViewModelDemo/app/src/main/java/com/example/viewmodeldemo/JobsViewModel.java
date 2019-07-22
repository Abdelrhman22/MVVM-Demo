package com.example.viewmodeldemo;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.viewmodeldemo.model.JobPojo;
import com.example.viewmodeldemo.remote.Repository;

import java.util.List;

public class JobsViewModel extends ViewModel {

    private Repository repository = Repository.getInstance();

    public MutableLiveData<List<JobPojo>> getJobs(String description,String location)
    {
        return repository.getJobs(description,location);
    }
}
