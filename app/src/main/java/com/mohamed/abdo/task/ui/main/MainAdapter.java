package com.mohamed.abdo.task.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mohamed.abdo.task.R;
import com.mohamed.abdo.task.pojo.DataModel;
import com.mohamed.abdo.task.pojo.UserModel;

import java.util.ArrayList;
import java.util.List;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    List<DataModel> userList = new ArrayList<>();

    public void setUserList(List<DataModel> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.firstName.setText("firstName : "+userList.get(position)
                .getFirst_name());
        holder.lastNAme.setText("lastName : "+userList.get(position)
                .getLast_name());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView firstName,lastNAme;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.tvFirstName);
            lastNAme = itemView.findViewById(R.id.tvLastName);
        }
    }
}
