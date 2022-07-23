package com.dharithri.mento_t;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.okhttp.internal.DiskLruCache;
import java.util.ArrayList;
import java.util.List;

public class userActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    com.google.firebase.database.DatabaseReference database;
    MyAdapter1 myAdapter;
    ArrayList<Users> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        recyclerView = (RecyclerView) findViewById(R.id.userList);
        database=FirebaseDatabase.getInstance().getReference("users");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        myAdapter = new MyAdapter1(this,list);
        recyclerView.setAdapter(myAdapter);
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Users user = dataSnapshot.getValue(Users.class);
                    list.add(user);
                }
                myAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}


//    RecyclerView recycleview;
//    DatabaseReference database;
//    ListAdapter myadapter;
//    ArrayList<user> list;
//
//
////    ListView myListview;
////    List<user> usersList;
////    DatabaseReference studentDbref;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user);
//        recycleview = findViewById(R.id.userList);
//        database = FirebaseDatabase.getInstance().getReference("ausers");
//        recycleview.setHasFixedSize(true);
//        recycleview.setLayoutManager(new LinearLayoutManager(this));
//        list = new ArrayList<>();
//        myadapter = new ListAdapter(this,list);
//        recycleview.setAdapter(myadapter);
//
//        database.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Toast.makeText(getApplicationContext(),
//                                "datacollected",
//                                Toast.LENGTH_LONG)
//                        .show();
//                System.out.println("Data Collection");
//                for (DataSnapshot db : snapshot.getChildren()) {
//                    user us = db.getValue(user.class);
//                    list.add(us);
//
//                }
//                myadapter.notifyDataSetChanged();
//            }
//
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//


//        myListview=findViewById(R.id.myListview);
//        usersList=new ArrayList<>();
//        studentDbref= FirebaseDatabase.getInstance().getReference("ausers");
//        studentDbref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                usersList.clear();
//                for(DataSnapshot db : snapshot.getChildren()){
//                    user us=db.getValue(user.class);
//                    usersList.add(us);
//
//
//                }
//                ListAdapter adapter=new ListAdapter(userActivity.this,usersList);
//                myListview.setAdapter(adapter);
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
