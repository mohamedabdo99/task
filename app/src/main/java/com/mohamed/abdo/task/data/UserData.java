package com.mohamed.abdo.task.data;

import com.mohamed.abdo.task.pojo.UserModel;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserData {
    @GET("users?")
    Call<UserModel> getUser(@Query("page") int page);
}
