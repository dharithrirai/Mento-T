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
import com.google.firebase.database.FirebaseDatabase;

public class admindashboard extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admindashboard);

        Button signup = findViewById(R.id.aregisterbtn2);
        Button bcktologin = findViewById(R.id.aloginnextbtn2);
        EditText edtname = findViewById(R.id.aname4);
        EditText edemail = findViewById(R.id.aemail4);
        EditText edphn = findViewById(R.id.phonenumber3);
        EditText edpass = findViewById(R.id.apassword3);

        signup.setOnClickListener(view ->
        {
            if (edtname.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please Enter Your name", Toast.LENGTH_SHORT).show();
            }
            if (edemail.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please Enter Your Email-Id", Toast.LENGTH_SHORT).show();
            }
            if (edphn.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please Enter Your Contact Number", Toast.LENGTH_SHORT).show();
            }
            if (edpass.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please Enter Your password", Toast.LENGTH_SHORT).show();
            }
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
            if (!(edtname.getText().toString().isEmpty() && edemail.getText().toString().isEmpty() && edpass.getText().toString().isEmpty()))

                firebaseAuth.createUserWithEmailAndPassword(edemail.getText().toString(), edpass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            String uid = task.getResult().getUser().getUid();
                            user us=new user(uid, edtname.getText().toString(), edphn.getText().toString(), edemail.getText().toString(), edpass.getText().toString());
                            firebaseDatabase.getReference().child("ausers").child(uid).setValue(us);

                            Intent in = new Intent(admindashboard.this, mentorLogin.class);
                            startActivity(in);
                        } else {
                            Toast.makeText(getApplicationContext(), task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            else
            {
                Toast.makeText(getApplicationContext(), "Fill all the fields", Toast.LENGTH_SHORT).show();

            }


        });
        bcktologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(admindashboard.this, mentorLogin.class));
                finish();
            }
        });

    }
}
