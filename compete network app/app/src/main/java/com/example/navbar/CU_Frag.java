package com.example.navbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navbar.Adapters.AdapterComp;
import com.example.navbar.Models.ModelComp;

import java.util.ArrayList;


public class CU_Frag extends Fragment {
    SearchView searchView;
    RecyclerView recycle;
    AdapterComp adapter;
    ArrayList<ModelComp> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_c_u_, container, false);
        recycle=v.findViewById(R.id.recycler);
        list=new ArrayList<>();
        RecyclerView.LayoutManager manager=new LinearLayoutManager(getContext());
        recycle.setLayoutManager(manager);
        list = new ArrayList<>();
        loadlist();
        adapter = new AdapterComp(list, getContext());
        recycle.setAdapter(adapter);

        return v;
    }
    private void loadlist() {
        list.add(new ModelComp(R.drawable.comp2,"CU Event","Bajaj"));
        list.add(new ModelComp(R.drawable.comp3,"Campus Ambassador Program","IIT Delhi"));
        list.add(new ModelComp(R.drawable.comp4,"Encipher","Google"));
        list.add(new ModelComp(R.drawable.comp5,"Loreal Brandstorm","L'oreal"));
        list.add(new ModelComp(R.drawable.comp1,"Bajaj CEO Challenge","Bajaj"));
        list.add(new ModelComp(R.drawable.comp1,"Campus Ambassador Program","IIT Delhi"));
        list.add(new ModelComp(R.drawable.comp1,"Encipher","Google"));
    }
    private AdapterComp getAdapter() {
        return adapter;
    }
}