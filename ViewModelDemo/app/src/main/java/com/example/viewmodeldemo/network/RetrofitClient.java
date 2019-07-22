package com.example.viewmodeldemo.network;

import com.example.viewmodeldemo.model.KeyTags;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;
    private static Retrofit getInstance()
    {
        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                .baseUrl(KeyTags.GITHUB_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
    // Generic createService
    public static <S> S createService(Class<S> serviceClass)
    {
        return getInstance().create(serviceClass);
    }
}
