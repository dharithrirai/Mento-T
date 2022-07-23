package com.dharithri.mento_t;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android .widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class HomeFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Inflate the layout for this fragment
        TextView txt = (TextView) view.findViewById(R.id.txt);
        TextView logout = (TextView) view.findViewById(R.id.logoutbutton2);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(getActivity(),MainActivity.class);
                startActivity(in);

            }
        });


        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();


        if (firebaseAuth.getCurrentUser() != null) {
            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myref = database.getReference("users").child(firebaseAuth.getUid());
            myref.addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    Users userModel = snapshot.getValue(Users.class);

                    SpannableString spannableString = new SpannableString("Hello" + " " + userModel.getName());
                    BackgroundColorSpan backgroundSpan = new BackgroundColorSpan(Color.WHITE);
                    spannableString.setSpan(backgroundSpan, 0, spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    txt.setText(spannableString);

                    Users currentUser = userModel;

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }

            });
        } else
        {
            Toast.makeText(getActivity().getApplicationContext(),
                            "error",
                            Toast.LENGTH_LONG)
                    .show();
        }
        return view;
    }
}









