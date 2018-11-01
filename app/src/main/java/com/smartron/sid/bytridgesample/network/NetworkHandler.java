package com.smartron.sid.bytridgesample.network;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class NetworkHandler {
    private static NetworkHandler networkInstance = new NetworkHandler();

    Interceptor interceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Response response = chain.proceed(chain.request());

            if (response.isSuccessful())
                return response;

            switch (response.code()) {
                case 400:
                    break;
            }
            return response;
        }
    };

    private OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(1000, TimeUnit.SECONDS)
            .connectTimeout(1000, TimeUnit.SECONDS)
            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(interceptor)
            .build();

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(NetworkApi.BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(StringConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    

    private NetworkApi networkApi = retrofit.create(NetworkApi.class);

    private NetworkHandler(){

    }

    public NetworkApi restApiInstance(){
        return networkApi;
    }

    public static NetworkHandler getInstance() {
        return networkInstance;
    }



}
