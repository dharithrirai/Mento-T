package com.dharithri.mento_t;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class sem1adapter extends RecyclerView.Adapter<sem1adapter.MyViewHolder> {
    LayoutInflater inflater;
    Context context;
    List<String>name, sub1,sub2;


    public sem1adapter(Context context, List<String>name,  List<String>sub1, List<String>sub2){
        this.inflater=LayoutInflater.from(context);
        this.name=name;
        this.sub1=sub1;
        this.sub2=sub2;

        Log.d( "TAG","Adapter"+ name);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.sem1list,parent,false);
        return new MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position) {
String Name=name.get(position);
String Sub1=sub1.get(position);
String Sub2=sub2.get(position);
holder.name.setText(Name);
holder.sub1.setText(Sub1);
holder.sub2.setText(Sub2);


    }
    @Override
    public int getItemCount() {
        return name.size();

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,sub1,sub2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.studentname);
            sub1 = itemView.findViewById(R.id.sub11);
            sub2= itemView.findViewById(R.id.sub12);

        }
    }

}

