package com.dharithri.mento_t;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class mentorLogin extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_login);
        EditText ledemail=findViewById(R.id.lemail2);
        Button signin = findViewById(R.id.loginbtn2);
        Button backtoreg=findViewById(R.id.bcktosignup2);
        EditText ledpass = findViewById(R.id.lpassword2);
        TextView forgotpassword = findViewById(R.id.forgotpassworda);
        mAuth = FirebaseAuth.getInstance();

        signin.setOnClickListener(view ->
        {

            if (ledemail.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please Enter Your Email-Id", Toast.LENGTH_SHORT).show();
            }

            if (ledpass.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please Enter Your password", Toast.LENGTH_SHORT).show();
            }
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

            String email, password;
            email = ledemail.getText().toString();
            password = ledpass.getText().toString();

            Task<AuthResult> authResultTask = firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(
                            new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(
                                        @NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getApplicationContext(),
                                                        "Login successful!!",
                                                        Toast.LENGTH_LONG)
                                                .show();


                                        Intent in = new Intent(mentorLogin.this, MentorActivity.class);
                                        startActivity(in);
                                    } else {
                                        Toast.makeText(getApplicationContext(),
                                                        "Login unsuccesfull!!",
                                                        Toast.LENGTH_LONG)
                                                .show();
                                    }
                                }
                            });

        });
        backtoreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(mentorLogin.this,admindashboard.class);
                startActivity(intent);
            }
        });

        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText resetMail = new EditText(view.getContext());
                AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(view.getContext());
                passwordResetDialog.setTitle("Reset Password");
                passwordResetDialog.setMessage("Enter your Email to reset password");
                passwordResetDialog.setView(resetMail);

                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String mail = resetMail.getText().toString();
                        mAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {

                                Toast.makeText(mentorLogin.this, "Reset Link Sent to Your Email", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(mentorLogin.this, "Error! Reset Link is Not sent" + e.getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        });

                    }
                });
                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                passwordResetDialog.create().show();
            }
        });
    }
}



























