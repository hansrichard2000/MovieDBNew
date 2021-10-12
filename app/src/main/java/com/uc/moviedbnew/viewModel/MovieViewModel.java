package com.uc.moviedbnew.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.uc.moviedbnew.model.Movies;
import com.uc.moviedbnew.model.NowPlaying;
import com.uc.moviedbnew.repositories.MovieRepository;

public class MovieViewModel extends AndroidViewModel {

    private MovieRepository repository;

    public MovieViewModel(@NonNull Application application){
        super(application);
        repository = MovieRepository.getInstance();
    }

    //==Begin of ViewModel getMovieById
    private MutableLiveData<Movies> resultGetMovieById = new MutableLiveData<>();
    public void getMovieById(String movieId){
        resultGetMovieById = repository.getMovieData(movieId);

    }

    public LiveData<Movies> getResultGetMovieById(){
        return resultGetMovieById;
    }
    //==End of ViewModel getMovieById

    //==Begin of ViewModel getNowPlaying
    private MutableLiveData<NowPlaying> resultGetNowPlaying = new MutableLiveData<>();
    public void getNowPlaying(){
        resultGetNowPlaying = repository.getNowPlayingData();

    }

    public MutableLiveData<NowPlaying> getResultNowPlaying(){
        return resultGetNowPlaying;
    }
    //==End of ViewModel getNowPlaying
}
