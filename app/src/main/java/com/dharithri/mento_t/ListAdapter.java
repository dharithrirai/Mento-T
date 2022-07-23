package com.dharithri.mento_t;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

//public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder>{
//    Context context;
//    ArrayList<user> list;
//
//    public ListAdapter(Context context, ArrayList<user> list) {
//        this.context = context;
//        this.list = list;
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v=LayoutInflater.from(context).inflate(R.layout.item,parent,false);
//        return new MyViewHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        user us=list.get(position);
//        holder.name.setText((us.getName()));
//        holder.usn.setText((us.getUsn()));
//
//        holder.email.setText((us.getEmail()));
//
//        holder.phone.setText((us.getPhno()));
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public static class MyViewHolder extends RecyclerView.ViewHolder{
//        TextView name,usn,email,phone;
//
//
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//            name=itemView.findViewById(R.id.tvName);
//            usn=itemView.findViewById(R.id.tvusn);
//
//            email=itemView.findViewById(R.id.tvemail);
//
//            phone=itemView.findViewById(R.id.tvcontact);
//
//
//        }
//    }
//
//}






//    private Activity mcontext;
//    List<user> usersList;
//    public ListAdapter(Activity mcontext,List<user>usersList){
//        super(mcontext,R.layout.list_item,usersList);
//        this.mcontext=mcontext;
//        this.usersList=usersList;
//
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        LayoutInflater inflater=mcontext.getLayoutInflater();
//        View listitemview=inflater.inflate(R.layout.list_item,null,true);
//        TextView tvname=listitemview.findViewById(R.id.tvname);
//        TextView tvusn=listitemview.findViewById(R.id.tvusn);
//        TextView tvemail=listitemview.findViewById(R.id.tvemail);
//        TextView tvcontact=listitemview.findViewById(R.id.tvcontact);
//        user user=usersList.get(position);
//        tvname.setText(user.getName());
//        tvusn.setText(user.getUsn());
//        tvemail.setText(user.getEmail());
//        tvcontact.setText(user.getPhno());
//        return listitemview;
//
//
//
//    }
//}
