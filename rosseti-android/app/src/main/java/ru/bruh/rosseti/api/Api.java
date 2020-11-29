package ru.bruh.rosseti.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import ru.bruh.rosseti.model.CreateStatementRequest;
import ru.bruh.rosseti.model.ProfileModel;
import ru.bruh.rosseti.model.StatementModel;

public interface Api {

    @GET("statements")
    Call<List<StatementModel>> getStatements();

    @GET("users/1")
    Call<ProfileModel> getProfile();

    @POST("/api/statements")
    Call<StatementModel> createStatement(@Body CreateStatementRequest request);

}