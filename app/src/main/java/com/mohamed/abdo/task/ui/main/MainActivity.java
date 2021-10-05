package com.mohamed.abdo.task.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mohamed.abdo.task.R;
import com.mohamed.abdo.task.databinding.ActivityMainBinding;
import com.mohamed.abdo.task.pojo.UserModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MainViewModel viewModel;
    private ActivityMainBinding binding;
    private MainAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        initButton();
        viewModel.getUsers(1);
        adapter = new MainAdapter();
        initRecyclerView();

    }
    private void initButton() {
        binding.btnPage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                viewModel.getUsers(1);
            }
        });
        binding.btnPage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                viewModel.getUsers(2);
            }
        });
        binding.btnPage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                viewModel.getUsers(3);
            }
        });
    }

    private void initRecyclerView() {
        binding.RecyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.RecyclerView.setAdapter(adapter);
        viewModel.userMutableLiveData.observe(this, new Observer<UserModel>()
        {
            @Override
            public void onChanged(UserModel userModel) {
                Log.d("onChanged",userModel.getData().toString());
                adapter.setUserList(userModel.getData());
            }
        });
    }
}