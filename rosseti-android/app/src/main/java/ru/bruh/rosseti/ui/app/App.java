package ru.bruh.rosseti.ui.app;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.bruh.rosseti.api.Api;

/**
 * @author Onanov Aleksey (@onanov)
 */
public class App extends Application {

    private Retrofit retrofit;

    public static Api api;

    @Override
    public void onCreate() {
        super.onCreate();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.101:8000/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        api = retrofit.create(Api.class);
    }


}
