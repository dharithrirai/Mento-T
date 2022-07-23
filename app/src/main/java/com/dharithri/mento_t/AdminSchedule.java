package com.dharithri.mento_t;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminSchedule extends AppCompatActivity {
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_schedule);
        EditText title = (EditText) findViewById(R.id.eTitle);
        EditText location = (EditText) findViewById(R.id.eLocation);
        EditText time = (EditText) findViewById(R.id.etime);
        EditText description = (EditText)findViewById(R.id.eDescription);
        Button addEvent = (Button)findViewById(R.id.addBtn);

        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!title.getText().toString().isEmpty() && !location.getText().toString().isEmpty() && !description.getText().toString().isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_INSERT);
                    intent.setData(CalendarContract.Events.CONTENT_URI);
                    intent.putExtra(CalendarContract.Events.TITLE, title.getText().toString());
                    intent.putExtra(CalendarContract.Events.DESCRIPTION, description.getText().toString());
                    intent.putExtra(CalendarContract.Events.EVENT_LOCATION, location.getText().toString());
                    intent.putExtra(CalendarContract.Events.ALL_DAY, "true");
                    intent.putExtra(Intent.EXTRA_EMAIL, "harshitha212019@gmail.com");
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                        databaseReference = firebaseDatabase.getReference("AMeet");
                        String Uid = firebaseAuth.getCurrentUser().getUid();
                        Users user=new Users();
                        Meets meet=new Meets(title.getText().toString(),location.getText().toString(),description.getText().toString(),Uid);
                        firebaseDatabase.getReference().child("AMeet").child(Uid).push().setValue(meet);
                        startActivity(intent);
                        Toast.makeText(AdminSchedule.this, "Meet details updated", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(AdminSchedule.this, "There is no app that can support this action", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(AdminSchedule.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}


