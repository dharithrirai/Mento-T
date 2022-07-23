package com.dharithri.mento_t;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TestActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        TextView auth = findViewById(R.id.testname);
        TextView title = findViewById(R.id.testtitle);
        Button test = findViewById(R.id.test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                firebaseDatabase = FirebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference("Author");
                String Uid = firebaseAuth.getCurrentUser().getUid();

                TestModel sub = new TestModel(auth.getText().toString(), title.getText().toString(), Uid);
                if
                ((auth.getText().toString().isEmpty() && title.getText().toString().isEmpty())) {
                    Toast.makeText(TestActivity.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    firebaseDatabase.getReference().child("author").child(Uid).setValue(sub);
                    Toast.makeText(TestActivity.this, "Entry Successfull", Toast.LENGTH_SHORT).show();
                    Intent intent = getIntent();
                    overridePendingTransition(0, 0);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    finish();
                    overridePendingTransition(0, 0);
                    startActivity(intent);
                }

            }
        });
    }
}