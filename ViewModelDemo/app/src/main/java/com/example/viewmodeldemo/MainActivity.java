package com.example.viewmodeldemo;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.viewmodeldemo.model.JobPojo;
import com.example.viewmodeldemo.network.NetworkConnection;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener
{
    List<JobPojo> jobsList = new ArrayList<>();
    JobsAdapter jobsAdapter;
    RecyclerView recyclerView;
    JobsViewModel jobsViewModel;
    SwipeRefreshLayout swipeRefreshLayout;
    NetworkConnection networkConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        swipeRefresh();
    }

    private void init() {
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        recyclerView = findViewById(R.id.recycler_view);
        networkConnection=new NetworkConnection(this);
    }

    public void getJobs()
    {
        jobsViewModel = ViewModelProviders.of(MainActivity.this).get(JobsViewModel.class);
        jobsViewModel.getJobs("java","uk").observe(this, jobListsresponse ->
        {
            jobsList.addAll(jobListsresponse);
            jobsAdapter.notifyDataSetChanged();
        });
        setupRecyclerView();
    }

    private void setupRecyclerView()
    {
        if (jobsAdapter == null)
        {
            jobsAdapter = new JobsAdapter(jobsList, this);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(jobsAdapter);
        } else
            {
            jobsAdapter.notifyDataSetChanged();
        }
    }


    private void swipeRefresh() {
        swipeRefreshLayout.setColorSchemeResources( android.R.color.holo_blue_dark );
        swipeRefreshLayout.setEnabled( true );
        swipeRefreshLayout.setOnRefreshListener( this );
        swipeRefreshLayout.post( new Runnable() {
            @Override
            public void run() {
                if(networkConnection.isNetworkAvailable(MainActivity.this))
                {
                    getJobs();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Check Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        } );
    }
    @Override
    public void onRefresh()
    {
        if(networkConnection.isNetworkAvailable(this))
        {
            swipeRefreshLayout.setRefreshing(false);
            getJobs();
        }
        else
        {
            swipeRefreshLayout.setRefreshing(false);
            Toast.makeText(this, "Check Internet Connection", Toast.LENGTH_SHORT).show();

        }
    }


}
