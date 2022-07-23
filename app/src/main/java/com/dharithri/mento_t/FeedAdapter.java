package com.dharithri.mento_t;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//public class FeedAdapter extends RecyclerView.Adapter {
//    Context context;
//    ArrayList<Email> list;
//
//    public FeedAdapter(Adminfeed adminfeed, ArrayList<Email> list) {
//        this.context = context;
//        this.list = list;
//    }
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(context).inflate(R.layout.feedlist, parent, false);
//        return new MyAdapter1.MyViewHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyAdapter1.MyViewHolder holder, int position) {
//        Email email = list.get(position);
//        System.out.println(position + "pos");
//        holder.Subject.setText(email.getSubject());
//        holder.description.setText(email.getDescription());
//        holder.date.setText(email.getDate());
//
//    }
//
//    @Override
//    public int getItemCount() {
//        System.out.println(list.size() + "size");
//        return list.size();
//    }
//
//    public static class MyViewHolder extends RecyclerView.ViewHolder {
//
//        TextView subject, description, date;
//
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//            subject = itemView.findViewById(R.id.Subjectfeed);
//            description= itemView.findViewById(R.id.Descriptionfeed);
//            date  = itemView.findViewById(R.id.datefeedid);
//
//        }
//    }
//}
//
//
//
//
public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.MyViewHolder> {

    Context context;
    ArrayList<Email> list;
    public FeedAdapter(Context context, ArrayList<Email> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.feedlist,parent,false);
        return new MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position) {
        Email email = list.get(position);
       System.out.println(position + "pos");
       holder.subject.setText(email.getSubject());
       holder.description.setText(email.getDescription());
       holder.date.setText(email.getDate());

    }
    @Override
    public int getItemCount() {
        System.out.println(list.size()+"size");
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView subject, description, date;

      public MyViewHolder(@NonNull View itemView) {
         super(itemView);
         subject = itemView.findViewById(R.id.Subjectfeed);
          description= itemView.findViewById(R.id.Descriptionfeed);
         date  = itemView.findViewById(R.id.datefeedid);

        }
    }

}

