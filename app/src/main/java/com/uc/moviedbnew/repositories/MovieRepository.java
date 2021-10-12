package com.uc.moviedbnew.repositories;

import android.graphics.Movie;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.uc.moviedbnew.helper.Const;
import com.uc.moviedbnew.model.Movies;
import com.uc.moviedbnew.retrofit.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private static MovieRepository repository;
    private static final String TAG = "MovieRepository";
    private MovieRepository(){

    }

    public static MovieRepository getInstance(){
        if (repository == null){
            repository = new MovieRepository();
        }
        return repository;
    }

    public MutableLiveData<Movies> getMovieData(String movieId){
        final MutableLiveData<Movies> result = new MutableLiveData<>();

        ApiService.endPoints().getMovieById(movieId, Const.API_KEY).enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {
                result.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Movies> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.toString());
            }
        });

        return result;
    }
}
