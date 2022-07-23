package com.dharithri.mento_t;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MentorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor);
        Button user=findViewById(R.id.userenetry);
        Button marks=findViewById(R.id.marksentry);
        Button schedule=findViewById(R.id.scheduleentry);
        Button notify=findViewById(R.id.notify);
        Button leaveentry=findViewById(R.id.leaveentry);
        Button activity=findViewById(R.id.activityentry2);
        TextView logout=findViewById(R.id.logoutbutton);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MentorActivity.this,MainActivity.class);
                startActivity(in);

            }
        });


        activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MentorActivity.this,adminactivity.class);
                startActivity(in);
            }
        });
//line up meet
        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MentorActivity.this,notifyActivity.class);
                startActivity(in);

            }
        });
        marks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MentorActivity.this,admindashboard.class);
                startActivity(in);
            }
        });
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MentorActivity.this,userActivity.class);
                startActivity(in);
            }
        });
        marks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MentorActivity.this,Adminmarks.class);
                startActivity(in);
            }
        });
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MentorActivity.this,AdminSchedule.class);
                startActivity(in);
            }
        });
        //UI Notify
        leaveentry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MentorActivity.this,Adminfeed.class);
                startActivity(in);

            }
        });

    }
}