package com.dharithri.mento_t;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//public class ActivityAdapter {
//}
public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.MyViewHolder> {

    Context context;
    ArrayList<Event> list;
    public ActivityAdapter(Context context, ArrayList<Event> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.activitylist,parent,false);
        return new MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position) {
        Event event = list.get(position);
        System.out.println(position+"pos");
        holder.Teventname .setText(event.getTeventname());
        holder.Teventyear .setText(event.getTeventyear());
        holder.Teventprize.setText(event.getTeventprize());
        holder.nteventname .setText(event.getNontecheventname());
        holder.nteventyear .setText(event.getNontecheventyear());
        holder.nteventprize.setText(event.getNontecheventprize());
        holder.name.setText(event.getName());

    }
    @Override
    public int getItemCount() {
        System.out.println(list.size()+"size");
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Teventname, Teventyear, Teventprize,nteventname,nteventyear,nteventprize,name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Teventname = itemView.findViewById(R.id.techevent);
            Teventyear = itemView.findViewById(R.id.techyear);
            Teventprize= itemView.findViewById(R.id.techprize);
            nteventname = itemView.findViewById(R.id.ntechevent);
            nteventyear = itemView.findViewById(R.id.ntechyear);
            nteventprize= itemView.findViewById(R.id.ntechprize);
            name=itemView.findViewById(R.id.partname);

        }
    }

}

