package com.mohamed.abdo.task.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mohamed.abdo.task.data.UserClient;
import com.mohamed.abdo.task.data.UserData;
import com.mohamed.abdo.task.pojo.DataModel;
import com.mohamed.abdo.task.pojo.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel
{
    MutableLiveData<UserModel> userMutableLiveData = new MutableLiveData<>();

    public void getUsers(int page)
    {
        UserClient.getInstance().getUsers(page).enqueue(new Callback<UserModel>()
        {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                userMutableLiveData.setValue(response.body());
                Log.d("onResponse","onResponse " + response.body());
            }
            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Log.d("onFailure","onFailure " + t.getMessage());

            }
        });
    }

}
