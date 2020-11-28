package ru.bruh.rosseti.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import ru.bruh.rosseti.model.StatementModel;

public interface Api {

    @GET("statements")
    Call<List<StatementModel>> getStatements();
/*
    @GET("internships")
    Call<List<ModelInternshipment>> getInternshipments();

    @GET("users/1")
    Call<ModelResponseJob> getResponsesJob();

    @GET("users/1")
    Call<ModelResponseInternship> getResponseInternship();

    @GET("users/1")
    Call<ModelResume> getResume();

    @POST("job_responses")
    Call<Object> createJobResponse(@Body ModelJobResponseRequest model);

    @POST("internship_responses")
    Call<Object> createInternshipResponse(@Body ModelInternshipResponseRequest model);*/

}