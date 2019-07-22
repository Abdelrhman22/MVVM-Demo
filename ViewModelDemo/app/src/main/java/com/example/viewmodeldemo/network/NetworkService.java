package com.example.viewmodeldemo.network;

import com.example.viewmodeldemo.api.GitHubAPI;

public class NetworkService {

    public GitHubAPI getGitHubAPI ()
    {
        return  RetrofitClient.createService(GitHubAPI.class);
    }
}
