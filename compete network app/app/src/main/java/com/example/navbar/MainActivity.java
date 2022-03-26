package com.example.navbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Filterable;
import android.widget.SearchView;

import com.example.navbar.FragmentsComp.ConferenceComp;
import com.example.navbar.FragmentsComp.FestComp;
import com.example.navbar.FragmentsComp.HackathonComp;
import com.example.navbar.FragmentsComp.InternComp;
import com.example.navbar.FragmentsComp.JobComp;
import com.example.navbar.FragmentsComp.QuizComp;
import com.example.navbar.FragmentsComp.ScholarComp;
import com.example.navbar.FragmentsComp.WorkshopComp;
import com.example.navbar.FragmentsComp.allComp;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.frame, new allComp()).commit();

        layout= findViewById(R.id.tabs);


        layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0){
                    getSupportFragmentManager().beginTransaction().add(R.id.frame, new allComp()).commit();
                }
                else if(tab.getPosition() == 1){
                    getSupportFragmentManager().beginTransaction().add(R.id.frame, new HackathonComp()).commit();
                }
                else if(tab.getPosition() == 2){
                    getSupportFragmentManager().beginTransaction().add(R.id.frame, new InternComp()).commit();
                }
                else if(tab.getPosition() == 3){

                }
                else if(tab.getPosition() == 4){
                    getSupportFragmentManager().beginTransaction().add(R.id.frame, new QuizComp()).commit();
                }
                else if(tab.getPosition() == 5){
                    getSupportFragmentManager().beginTransaction().add(R.id.frame, new JobComp()).commit();
                }
                else if(tab.getPosition() == 6){
                    getSupportFragmentManager().beginTransaction().add(R.id.frame, new ScholarComp()).commit();
                }
                else if(tab.getPosition() == 7){
                    getSupportFragmentManager().beginTransaction().add(R.id.frame, new WorkshopComp()).commit();
                }
                else if(tab.getPosition() == 8){
                    getSupportFragmentManager().beginTransaction().add(R.id.frame, new ConferenceComp()).commit();
                }
                else if(tab.getPosition() == 9){
                    getSupportFragmentManager().beginTransaction().add(R.id.frame, new FestComp()).commit();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}