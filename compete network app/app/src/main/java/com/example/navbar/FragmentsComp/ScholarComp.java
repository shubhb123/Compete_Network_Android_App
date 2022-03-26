package com.example.navbar.FragmentsComp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navbar.Adapters.AdapterComp;
import com.example.navbar.Classes.RecyclerItemClickListener;
import com.example.navbar.Models.ModelComp;
import com.example.navbar.R;
import com.example.navbar.ScrollingActivity;

import java.util.ArrayList;


public class ScholarComp extends Fragment {
    RecyclerView recyclerView;

    ArrayList<ModelComp> list= new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_scholar_comp,container,false);
        recyclerView= view.findViewById(R.id.recycleralls);

        list.add(new ModelComp(R.drawable.comp3,"Scholarship","IIT Delhi"));
        list.add(new ModelComp(R.drawable.comp1,"Encipher","Google"));
        list.add(new ModelComp(R.drawable.comp5,"Loreal Brandstorm","L'oreal"));
        list.add(new ModelComp(R.drawable.comp2,"Loreal Brandstorm","L'oreal"));
        list.add(new ModelComp(R.drawable.comp4,"Bajaj CEO Challenge","Bajaj"));
        list.add(new ModelComp(R.drawable.comp1,"Bajaj CEO Challenge","Bajaj"));
        list.add(new ModelComp(R.drawable.comp1,"Campus Ambassador Program","IIT Delhi"));
        list.add(new ModelComp(R.drawable.comp1,"Encipher","Google"));

        AdapterComp adapterComp1= new AdapterComp(list, getContext());
        recyclerView.setAdapter(adapterComp1);

        LinearLayoutManager layoutManager= new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position){
                    case 0:
                        Intent intent= new Intent(getContext(), ScrollingActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1= new Intent(getContext(), ScrollingActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2= new Intent(getContext(), ScrollingActivity.class);
                        startActivity(intent2);
                        break;
                }
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

        return view;
    }
}