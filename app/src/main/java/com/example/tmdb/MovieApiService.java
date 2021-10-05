package com.example.tmdb;

import com.example.tmdb.model.Tmdb;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApiService {
    @GET("movie/popular")
    Call<Tmdb> getMovie(@Query("api_key") String apiKey);
}
