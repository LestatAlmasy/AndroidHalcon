package com.lestat.halconmilenario;

import com.lestat.halconmilenario.serviceClass.events;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;

/**
 * Created by Lestat on 06-07-2016.
 */
public interface RestInterface {

    @Headers("Content-Type: x-www-form-urlencoded")
    @POST("/events")
    public void NuevoEvento(@Body events cApp, Callback<events> callback);

}
