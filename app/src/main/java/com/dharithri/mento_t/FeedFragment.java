package com.dharithri.mento_t;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FeedFragment extends Fragment {
    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;
    EditText editTextTo, editTextSubject, editTextMessage, editTextdate;
    Button send;


    public FeedFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feed, container, false);



        editTextTo = (EditText) view.findViewById(R.id.editText1);
        editTextSubject = (EditText) view.findViewById(R.id.editText2);
        editTextMessage = (EditText) view.findViewById(R.id.editText3);
        editTextdate = (EditText) view.findViewById(R.id.datefeed);

        send = (Button) view.findViewById(R.id.button1);

        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String to = editTextTo.getText().toString();
                String subject = editTextSubject.getText().toString();
                String message = editTextMessage.getText().toString();
                String date = editTextdate.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                firebaseDatabase = FirebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference("Email");
                String Uid = firebaseAuth.getCurrentUser().getUid();
                Email e=new Email(date,to,subject,message,Uid);
                firebaseDatabase.getReference().child("Email").child(Uid).setValue(e);
                Toast.makeText(getActivity(), "Mail details updated", Toast.LENGTH_SHORT).show();


            }

        });

        return view;

    }

}

