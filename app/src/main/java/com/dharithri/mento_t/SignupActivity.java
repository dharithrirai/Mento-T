package com.dharithri.mento_t;

import  androidx.annotation.NonNull;
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

public class SignupActivity extends AppCompatActivity {

//    dbhelper DB;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentee);
        Button signup = findViewById(R.id.aregisterbtn);
        Button bcktologin = findViewById(R.id.aloginnextbtn);
//        EditText edusn = findViewById(R.id.usn);
        EditText edtname = findViewById(R.id.aname);
        EditText edemail = findViewById(R.id.aemail);
        EditText edphn = findViewById(R.id.phonenumber);
        EditText edpass = findViewById(R.id.apassword);
        EditText usn=findViewById(R.id.ausn);
//        EditText edrepass = findViewById(R.id.renterpassword);
//
//        DB = new dbhelper(this);
//
//        signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String usn = edusn.getText().toString();
//                String name = edtname.getText().toString();
//                String email = edemail.getText().toString();
//                String phone = edphn.getText().toString();
//                String password = edpass.getText().toString();
//                String repass = edrepass.getText().toString();
//





//                if (usn.equals("") || name.equals("") || email.equals("") || phone.equals("") || password.equals("") || repass.equals("")) {
//                    Toast.makeText(SignupActivity.this, "Fill all the details ", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    if(password.equals(repass)){
//                        Boolean usercheckresult=DB.checkusernames(usn);
//                        if(usercheckresult==false){
//                            Boolean regresult=DB.insertData(usn, name, email,phone,password);
//                            if(regresult==true){
//                                Toast.makeText(SignupActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
//                                Intent intent=new Intent(getApplicationContext(),signinActivity.class);
//                                startActivity(intent);
//                            }
//                            else
//                            {
//                                Toast.makeText(SignupActivity.this,"Registration failed",Toast.LENGTH_SHORT).show();
//                            }
//
//                        }
//                        else
//                        {
//                            Toast.makeText(SignupActivity.this,"User Already exists \n Please sign in",Toast.LENGTH_SHORT).show();
//                        }
//
//                    }
//                    else
//                    {
//                        Toast.makeText(SignupActivity.this, "Password not matching", Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//            }
//        });
//  bcktologin.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View view) {
//
//      }
//  });
//    }
//

                signup.setOnClickListener(view ->
                {
//                    if (edtname.getText().toString().isEmpty()) {
//                        Toast.makeText(getApplicationContext(), "Please Enter Your name", Toast.LENGTH_SHORT).show();
//                    }
//                    if (edemail.getText().toString().isEmpty()) {
//                        Toast.makeText(getApplicationContext(), "Please Enter Your Email-Id", Toast.LENGTH_SHORT).show();
//                    }
//                    if (edphn.getText().toString().isEmpty()) {
//                        Toast.makeText(getApplicationContext(), "Please Enter Your Contact Number", Toast.LENGTH_SHORT).show();
//                    }
//                    if (edpass.getText().toString().isEmpty()) {
//                        Toast.makeText(getApplicationContext(), "Please Enter Your password", Toast.LENGTH_SHORT).show();
//                    }
                    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                    if (!(edtname.getText().toString().isEmpty() || edemail.getText().toString().isEmpty() || edpass.getText().toString().isEmpty()||edphn.getText().toString().isEmpty()||usn.getText().toString().isEmpty() )) {


                        firebaseAuth.createUserWithEmailAndPassword(edemail.getText().toString(), edpass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    String uid = task.getResult().getUser().getUid();
                                    Users user = new Users(uid, edtname.getText().toString(), usn.getText().toString(), edphn.getText().toString(), edemail.getText().toString(), edpass.getText().toString(), 0);
                                    firebaseDatabase.getReference().child("users").child(uid).setValue(user);

                                    Intent in = new Intent(SignupActivity.this, signinActivity.class);
                                    startActivity(in);
                                } else {
                                    Toast.makeText(getApplicationContext(), task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }

                        });
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Fill all the fields", Toast.LENGTH_SHORT).show();
                    }
                });
                bcktologin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(SignupActivity.this, signinActivity.class));
                        finish();
                    }
                });

            }
        }
