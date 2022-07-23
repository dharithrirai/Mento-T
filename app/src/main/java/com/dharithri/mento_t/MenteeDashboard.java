package com.dharithri.mento_t;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.internal.service.Common;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.widget.TextView;
import android.widget.Toolbar;


import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.net.HttpCookie;

public class MenteeDashboard extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationview;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);





        TextView txt=findViewById(R.id.menteetxt);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

        if(firebaseAuth.getCurrentUser()!=null) {
            final FirebaseDatabase database =FirebaseDatabase.getInstance();
            DatabaseReference myref=database.getReference("users").child(firebaseAuth.getUid());
            myref.addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    Users userModel=  snapshot.getValue(Users.class);

                    SpannableString spannableString = new SpannableString("Hello"+" "+userModel.getName());
                    BackgroundColorSpan backgroundSpan = new BackgroundColorSpan(Color.YELLOW);
                    spannableString.setSpan(backgroundSpan, 0, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    txt.setText(spannableString);

                    Users currentUser = userModel;

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }

            });
        }else{
            Toast.makeText(getApplicationContext(),
                    "error",
                    Toast.LENGTH_LONG)
                    .show();
        }



    }



}


