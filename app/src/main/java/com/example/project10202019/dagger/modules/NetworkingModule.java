package com.example.project10202019.dagger.modules;

import com.example.project10202019.interfaces.PostApiService;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkingModule {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @Provides
    @Singleton
    static Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    static PostApiService provideApiService(Retrofit retrofit){
        return retrofit.create(PostApiService.class);
    }

}
