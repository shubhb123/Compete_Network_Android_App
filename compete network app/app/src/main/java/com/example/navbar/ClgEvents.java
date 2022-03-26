package com.example.navbar;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class ClgEvents extends AppCompatActivity {
    Spinner spinner;
    String clgs[]={"CEC", "COE", "DU", "CU", "IIT Delhi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clg_events);
        spinner=findViewById(R.id.spin);
        ArrayAdapter<String>adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, clgs);
        spinner.setAdapter(adapter);
        getSupportFragmentManager().beginTransaction().add(R.id.frame, new CEC_Frag()).commit();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Fragment frag=new CEC_Frag();
                if (spinner.getSelectedItemPosition()==0)
                    frag=new CEC_Frag();
                else if (spinner.getSelectedItemPosition()==1)
                    frag=new COE_Frag();
                else if (spinner.getSelectedItemPosition()==2)
                    frag=new DelhiU_Frag();
                else if (spinner.getSelectedItemPosition()==3)
                    frag=new CU_Frag();
                else if (spinner.getSelectedItemPosition()==4)
                    frag=new IIT_D_Frag();


                getSupportFragmentManager().beginTransaction().add(R.id.frame, frag).commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}