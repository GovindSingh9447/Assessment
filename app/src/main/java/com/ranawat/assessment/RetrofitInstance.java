package com.ranawat.assessment;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private  static Retrofit retrofit;
    private  static final String BASEURL="https://simplifiedcoding.net/";

    public static Retrofit getRetrofit(){
        if (retrofit ==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }

}
