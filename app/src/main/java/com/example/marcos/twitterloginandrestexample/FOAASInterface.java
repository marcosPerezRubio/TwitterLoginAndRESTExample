package com.example.marcos.twitterloginandrestexample;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by marcos on 01/02/2017.
 */

public interface FOAASInterface {

    @Headers({
            "Accept: application/json"
    })
    @GET("/version")
    Call<FOOASMessage> getVersion();


}
