package com.dharithri.mento_t;
import android.content.Context;
import android.icu.text.CaseMap;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class notifyAdapter extends RecyclerView.Adapter<notifyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Meet> list;
    public notifyAdapter(Context context, ArrayList<Meet> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.notifylist,parent,false);
        return new MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position) {
        Meet meet = list.get(position);
        System.out.println(position+"pos");
        holder.Title .setText(meet.getTitle());
        holder.Location .setText(meet.getLocation());
        holder.Description.setText(meet.getDescription());
        holder.Date.setText(meet.getDate());

        holder.Time.setText(meet.getTime());

    }
    @Override
    public int getItemCount() {
        System.out.println(list.size()+"size");
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Title,Location, Description, Date, Time;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Title = itemView.findViewById(R.id.sendertitle);
            Location= itemView.findViewById(R.id.senderlocation);
            Description= itemView.findViewById(R.id.senderdescription);
            Date= itemView.findViewById(R.id.senderDate);
            Time= itemView.findViewById(R.id.sendertime);


        }
    }

}

