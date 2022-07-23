package com.dharithri.mento_t;

import android.content.Intent;
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


public class ActivityFragment extends Fragment {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    public ActivityFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity, container, false);
        Button entry = (Button) view.findViewById(R.id.actsub);
        EditText teventname = (EditText) view.findViewById(R.id.evntnametec);
        EditText teventyear = (EditText) view.findViewById(R.id.eventyeart);
        EditText teventprize = (EditText) view.findViewById(R.id.eventplacet);
        EditText nteventname = (EditText) view.findViewById(R.id.evntnament);
        EditText nteventyear = (EditText) view.findViewById(R.id.eventyeartnt);
        EditText nteventprize = (EditText) view.findViewById(R.id.eventplacetnt);
        EditText name = (EditText) view.findViewById(R.id.participantname);

        entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (teventname.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity().getApplicationContext(), "Please Enter technical event name", Toast.LENGTH_SHORT).show();
                }
                if (teventname.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity().getApplicationContext(), "Please Enter the technical event year", Toast.LENGTH_SHORT).show();
                }
                if (teventname.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity().getApplicationContext(), "Please Enter the technical event prize", Toast.LENGTH_SHORT).show();
                }
                if (teventname.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity().getApplicationContext(), "Please Enter nontechnical event name", Toast.LENGTH_SHORT).show();
                }
                if (teventname.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity().getApplicationContext(), "Please Enter the nontechnical event year", Toast.LENGTH_SHORT).show();
                }
                if (teventname.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity().getApplicationContext(), "Please Enter the nontechnical event prize", Toast.LENGTH_SHORT).show();
                }
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                firebaseDatabase = FirebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference("Events");
                String Uid = firebaseAuth.getCurrentUser().getUid();
                Event event = new Event(name.getText().toString(),teventname.getText().toString(), teventyear.getText().toString(), teventprize.getText().toString(), nteventname.getText().toString(), nteventyear.getText().toString(), nteventprize.getText().toString(), Uid);
                if
                ((teventname.getText().toString().isEmpty() && teventyear.getText().toString().isEmpty() && teventprize.getText().toString().isEmpty() && nteventname.getText().toString().isEmpty() && nteventyear.getText().toString().isEmpty() && nteventprize.getText().toString().isEmpty())) {
                    Toast.makeText(getActivity(), "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    firebaseDatabase.getReference().child("Event").child(Uid).setValue(event);
                    Toast.makeText(getActivity(), "Entry Successfull", Toast.LENGTH_SHORT).show();
                    Intent intent = getActivity().getIntent();
                    getActivity().overridePendingTransition(0,0);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    getActivity().finish();
                    getActivity().overridePendingTransition(0,0);
                    startActivity(intent);
                }

            }
        });
        return view;
    }
}

