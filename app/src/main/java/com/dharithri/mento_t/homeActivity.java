package com.dharithri.mento_t;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toolbar;

import com.dharithri.mento_t.databinding.ActivityHomeBinding;

public class homeActivity extends AppCompatActivity {
    private Toolbar toolbar;
    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHomeBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        replacefragment(new HomeFragment());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch(item.getItemId()){
                case R.id.Home:
                    replacefragment(new HomeFragment());
                    break;
                case R.id.Marks:
                    replacefragment(new ProfileFragment());
                    break;
                case R.id.Schedule:
                    replacefragment(new ScheduleFragment());
                    break;

                case R.id.Activity:
                    replacefragment(new ActivityFragment());
                    break;

                case R.id.feed:
                    replacefragment(new FeedFragment());
                    break;


            }
            return true;
        });
    }


    private void replacefragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}