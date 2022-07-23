package com.dharithri.mento_t;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ScheduleFragment extends Fragment {

    FirebaseDatabase firebaseDatabase;
    com.google.firebase.database.DatabaseReference database;
    DatabaseReference databaseReference;

    Users user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        EditText title = (EditText) view.findViewById(R.id.eTitle);
        EditText location = (EditText) view.findViewById(R.id.eLocation);
        EditText time = (EditText) view.findViewById(R.id.etime);
        EditText date = (EditText) view.findViewById(R.id.edate);
        EditText description = (EditText) view.findViewById(R.id.eDescription);
        Button addEvent = (Button) view.findViewById(R.id.addBtn);
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
                    if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                        firebaseDatabase = FirebaseDatabase.getInstance();
                        databaseReference = firebaseDatabase.getReference("Meet");
                        String Uid = firebaseAuth.getCurrentUser().getUid();
                        Meet meet=new Meet(title.getText().toString(),location.getText().toString(),description.getText().toString(),time.getText().toString(),date.getText().toString(),Uid);
                        firebaseDatabase.getReference().child("Meet").child(Uid).setValue(meet);
                        startActivity(intent);
                        Toast.makeText(getActivity(), "Meet details updated", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "There is no app that can support this action", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;

    }

}





