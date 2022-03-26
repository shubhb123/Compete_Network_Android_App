package com.example.navbar.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navbar.Models.ModelComp;
import com.example.navbar.R;

import java.util.ArrayList;

public class AdapterComp extends RecyclerView.Adapter<AdapterComp.viewHolder>{
    ArrayList<ModelComp> list;
    Context context;

    public AdapterComp(ArrayList<ModelComp> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.samplerecycler,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ModelComp model= list.get(position);
        holder.imageView.setImageResource(model.getPic());
        holder.text1.setText(model.getText());
        holder.text2.setText(model.getText1());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView text1, text2;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView= itemView.findViewById(R.id.imageView);
            text1= itemView.findViewById(R.id.text11);
            text2= itemView.findViewById(R.id.text22);
        }
    }

}
