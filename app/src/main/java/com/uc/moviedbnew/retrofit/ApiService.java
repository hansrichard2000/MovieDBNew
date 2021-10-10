package com.uc.moviedbnew.retrofit;

import com.uc.moviedbnew.helper.Const;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static Retrofit retrofit;

    public static ApiEndPoints endPoints(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiEndPoints.class);
    }
}
