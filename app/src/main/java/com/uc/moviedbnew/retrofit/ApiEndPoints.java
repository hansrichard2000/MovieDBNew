package com.uc.moviedbnew.retrofit;

import com.uc.moviedbnew.model.Movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndPoints {

    @GET("movie/{movie_id}")
    Call<Movies> getMovieById(
      @Path("movie_id") String movieId,
      @Query("api_key") String apiKey
    );

}
