package com.dharithri.mento_t;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.auth.User;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class testmainactivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testmainactivity);
        listView=findViewById(R.id.sampleListView);
        ArrayList<String>list= new ArrayList<>();
        ArrayAdapter adapter=new ArrayAdapter<String>(this,R.layout.testlist,list);
        listView.setAdapter(adapter);
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference("users");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();


                for(DataSnapshot snapshot1: snapshot.getChildren())
                {
                    Users info=snapshot1.getValue(Users.class);
                    String txt= "Name:"+info.getName()+"  Usn:"+info.getUsn()+"  Phn:"+info.getPhno();
                    list.add(txt);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}