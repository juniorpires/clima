package com.caruaru.pe.clima.request;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ClimaRequest {

    @GET("weather?appid="+RetrofitClient.API_KEY)
    Call<String> getClima(@Query("q") String q);
}