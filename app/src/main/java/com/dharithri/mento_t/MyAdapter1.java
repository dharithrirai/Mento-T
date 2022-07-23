package com.dharithri.mento_t;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.MyViewHolder> {

    Context context;
    ArrayList<Users> list;
    public MyAdapter1(Context context, ArrayList<Users> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position) {
        Users user = list.get(position);
        System.out.println(position+"pos");
        holder.Name .setText(user.getName());
        holder.Usn .setText(user.getUsn());
        holder.Phon.setText(user.getPhno());
    }
    @Override
    public int getItemCount() {
        System.out.println(list.size()+"size");
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Name, Usn, Phon;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.username);
            Usn = itemView.findViewById(R.id.userusn);
            Phon= itemView.findViewById(R.id.userphone);

        }
    }

}

