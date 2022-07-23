package com.dharithri.mento_t;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Sem2Activity extends AppCompatActivity {
    // Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReference;

    // creating a variable for
    // our object class


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem2);
        EditText maths = findViewById(R.id.maths1);
        EditText chem = findViewById(R.id.chem);

        EditText cps = findViewById(R.id.cps);

        EditText eln = findViewById(R.id.eln);

        EditText mech = findViewById(R.id.mech);

        EditText chel = findViewById(R.id.chel);
        EditText cpl = findViewById(R.id.cpl);
        Button sem2sub = findViewById(R.id.sem2sub);
        sem2sub.setOnClickListener(view ->
        {
            if (maths.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please Enter math marks", Toast.LENGTH_SHORT).show();
            }
            if (chem.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please Enter chem marks", Toast.LENGTH_SHORT).show();
            }
            if (cps
                    .getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please Enter cps marks", Toast.LENGTH_SHORT).show();
            }
            if (eln.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please Enter eln marks", Toast.LENGTH_SHORT).show();
            }
            if (mech.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please Enter mech marks", Toast.LENGTH_SHORT).show();
            }
            if (chel.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please Enter chel marks", Toast.LENGTH_SHORT).show();
            }
            if (cpl.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please Enter cpl marks", Toast.LENGTH_SHORT).show();
            }
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
            firebaseDatabase = FirebaseDatabase.getInstance();
            databaseReference = firebaseDatabase.getReference("Users");
            String Uid = firebaseAuth.getCurrentUser().getUid();

            Subject1 sub = new Subject1(maths.getText().toString(), chem.getText().toString(), cps.getText().toString(), eln.getText().toString(), mech.getText().toString(), chel.getText().toString(), cpl.getText().toString(),Uid);

            if
            ((maths.getText().toString().isEmpty() && chem.getText().toString().isEmpty() && cps.getText().toString().isEmpty() && eln.getText().toString().isEmpty() && mech.getText().toString().isEmpty() && chel.getText().toString().isEmpty() && cpl.getText().toString().isEmpty())) {
                Toast.makeText(Sem2Activity.this, "Please add some data.", Toast.LENGTH_SHORT).show();
            } else {
                firebaseDatabase.getReference().child("Scores").child("sem2").child(Uid).setValue(sub);
                Toast.makeText(Sem2Activity.this, "Entry Successfull", Toast.LENGTH_SHORT).show();
                Intent intent = getIntent();
                overridePendingTransition(0, 0);

                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

                finish();
                overridePendingTransition(0, 0);

                startActivity(intent);
            }



        });
    }
}