package com.lestat.halconmilenario;

import com.lestat.halconmilenario.serviceClass.armaments;
import com.lestat.halconmilenario.serviceClass.events;
import com.lestat.halconmilenario.serviceClass.users;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;

/**
 * Created by Lestat on 06-07-2016.
 */
public interface RestInterface {

    @Headers("Content-Type: application/json")
    @POST("/events")
    public void NuevoEvento(@Body events cApp, Callback<events> callback);

    @Headers("Content-Type: application/json")
    @GET("/armaments")
    public void TotalArmamento(Callback<armaments> callback);

    @Headers("Content-Type: application/json")
    @POST("/login")
    public void Login(@Body users caa, Callback<users> callback);

    @Headers("Content-Type: application/json")
    @PUT("/disparar/{id}")
    public void disparar(@Path("id")String id, Callback<armaments> callback);
}
