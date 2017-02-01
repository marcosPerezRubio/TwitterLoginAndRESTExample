package com.example.marcos.twitterloginandrestexample;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by marcos on 01/02/2017.
 */

public interface FOAASInterface {

    @Headers({ "Accept: application/json" })
    @GET("/version")
    Call<FOOASMessage> getVersion();

    @Headers({ "Accept: application/json" })
    @GET("/that/{from}")
    Call<FOOASMessage> getThat(@Path("from") String from);

    @Headers({ "Accept: application/json" })
    @GET("/nugget/{name}/{from}")
    Call<FOOASMessage> getNugget(@Path("name") String name,@Path("from") String from);

    @Headers({ "Accept: application/json" })
    @GET("/fascinating/{from}")
    Call<FOOASMessage> getFascinating(@Path("from") String from);

}
