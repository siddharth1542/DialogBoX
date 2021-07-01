package com.codewithsid.dialogbox;

import com.codewithsid.dialogbox.models.Models;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostRetrofitApi {

    // https://backend-test-zypher.herokuapp.com/testData


    @POST("testData")
    Call<Models> postDataIntoServer();

}
