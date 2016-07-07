package com.lestat.halconmilenario;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

/**
 * Created by Lestat on 06-07-2016.
 */
public class ClientAPI   {

    private static final String API_BASE_URL = "http://nuevohalcon-cein2016.rhcloud.com/api";

    private retrofit.RestAdapter restAdapter;
    private RestInterface apiService;
    Context context;

    public ClientAPI()
    {
        restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        apiService = restAdapter.create(RestInterface.class);
    }

    public RestInterface getService()
    {
        return apiService;
    }
}
