package com.example.mainza1992.apidemo.data.network.service;

import com.example.mainza1992.apidemo.data.network.model.API_Constants;
import com.example.mainza1992.apidemo.MyApp;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mainza1992 on 27/09/2017.
 */

public class ConnectionService {

    static Retrofit retrofit;
    static OkHttpClient okHttpClient;

    public static IRequestInterface getConnectionService(){
       // okHttpClient = buildClient();
        retrofit = new Retrofit.Builder()
                .baseUrl(API_Constants.BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
               // .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(IRequestInterface.class);
    }


    public static OkHttpClient buildClient() {
//
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //  builder.addNetworkInterceptor(new ResponseCacheInterceptor());
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        builder.addInterceptor(interceptor).build();
        // Enable response caching
        builder .addNetworkInterceptor(new Offline_CacheData.ResponseCacheInterceptor());
        builder .addInterceptor(new Offline_CacheData.OfflineResponseCacheInterceptor())
                // Set the cache location and size (5 MB)
                .cache(new okhttp3.Cache(new File(MyApp
                        .getContext().getCacheDir(),
                        "apiResponses"), 5 * 1024 * 1024));
        return new OkHttpClient();


    }


}
