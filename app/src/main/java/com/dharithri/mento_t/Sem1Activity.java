package com.dharithri.mento_t;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Sem1Activity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem1);



//        EditText maths = findViewById(R.id.maths);
//        EditText phys = findViewById(R.id.phys);
//        EditText ele = findViewById(R.id.ele);
//        EditText eng = findViewById(R.id.eng);
//
//        EditText cad = findViewById(R.id.cad);
//
//        EditText phyl = findViewById(R.id.phyl);
//        EditText elel = findViewById(R.id.elel);
//        Button sem1sub = findViewById(R.id.sem1sub);
//        sem1sub.setOnClickListener(view ->
//        {
//            if (maths.getText().toString().isEmpty()) {
//                Toast.makeText(getApplicationContext(), "Please Enter math marks", Toast.LENGTH_SHORT).show();
//            }
//            if (phys.getText().toString().isEmpty()) {
//                Toast.makeText(getApplicationContext(), "Please Enter phys marks", Toast.LENGTH_SHORT).show();
//            }
//            if (ele.getText().toString().isEmpty()) {
//                Toast.makeText(getApplicationContext(), "Please Enter ele marks", Toast.LENGTH_SHORT).show();
//            }
//            if (eng.getText().toString().isEmpty()) {
//                Toast.makeText(getApplicationContext(), "Please Enter eng marks", Toast.LENGTH_SHORT).show();
//            }
//            if (cad.getText().toString().isEmpty()) {
//                Toast.makeText(getApplicationContext(), "Please Enter cad marks", Toast.LENGTH_SHORT).show();
//            }
//            if (phyl.getText().toString().isEmpty()) {
//                Toast.makeText(getApplicationContext(), "Please Enter phyl marks", Toast.LENGTH_SHORT).show();
//            }
//            if (elel.getText().toString().isEmpty()) {
//                Toast.makeText(getApplicationContext(), "Please Enter elel marks", Toast.LENGTH_SHORT).show();
//            }
//            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
//            firebaseDatabase = FirebaseDatabase.getInstance();
//            databaseReference = firebaseDatabase.getReference("Users");
//            String Uid = firebaseAuth.getCurrentUser().getUid();
//
//            Subject sub = new Subject(maths.getText().toString(), phys.getText().toString(), ele.getText().toString(), eng.getText().toString(), cad.getText().toString(), phyl.getText().toString(), elel.getText().toString(),Uid);
//            if
//            ((maths.getText().toString().isEmpty() && phys.getText().toString().isEmpty() && ele.getText().toString().isEmpty() && eng.getText().toString().isEmpty() && cad.getText().toString().isEmpty() && phyl.getText().toString().isEmpty() && elel.getText().toString().isEmpty())) {
//                Toast.makeText(Sem1Activity.this, "Please add some data.", Toast.LENGTH_SHORT).show();
//            } else {
//                firebaseDatabase.getReference().child("Scores").child("sem1").child(Uid).setValue(sub);
//                Toast.makeText(Sem1Activity.this, "Entry Successfull", Toast.LENGTH_SHORT).show();
//                Intent intent = getIntent();
//                overridePendingTransition(0, 0);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
//                finish();
//                overridePendingTransition(0, 0);
//                startActivity(intent);
//            }
//
//        });
    }
    }




