package com.mohamed.abdo.task.data;

import com.mohamed.abdo.task.pojo.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserClient {
    private static final String BASE_UEL = "https://reqres.in/api/";
    private  UserData userData;
    private static UserClient INSTANT;

    public UserClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_UEL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        userData = retrofit.create(UserData.class);
    }
    public static  UserClient getInstance(){
        if (null == INSTANT)
        {
            INSTANT = new UserClient();
        }
        return  INSTANT;
    }

    public Call<UserModel> getUsers(int page)
    {
        return userData.getUser(page);
    }
}
