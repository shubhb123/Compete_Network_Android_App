package com.example.navbar;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.navbar.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.UUID;

public class eventwork<var> extends AppCompatActivity {

    ImageView imageView;
    Button choose, adddata;
    EditText eventname, eventdate, eventtime, contact, deadline, description, reglink, rewards, venue;
    Bitmap bitmap;
    FirebaseStorage storage;
    Uri imageuri;
    FirebaseDatabase database;
    DatabaseReference reference;
    int maxid=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventwork);

        eventname= findViewById(R.id.eventname);
        reglink= findViewById(R.id.register);
        eventdate= findViewById(R.id.date);
        eventtime= findViewById(R.id.time);
        deadline= findViewById(R.id.deadline);
        venue= findViewById(R.id.venue);
        description= findViewById(R.id.about);
        contact= findViewById(R.id.contact);
        rewards= findViewById(R.id.rewards);
        database= FirebaseDatabase.getInstance();
        reference= database.getReference();

        imageView = (ImageView) findViewById(R.id.mainimage);
        adddata = findViewById(R.id.add);
        choose = findViewById(R.id.choose);
        storage= FirebaseStorage.getInstance();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGetContent.launch("image/*");
            }
        });

        adddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
            }
        });


    }

    private void uploadImage() {
        if(imageuri != null){
            StorageReference reference= storage.getReference().child("images/"+ UUID.randomUUID().toString());

            reference.putFile(imageuri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                    if(task.isSuccessful()){
                        savetodatabase();
                        Toast.makeText(getApplicationContext(), "Image & Information Added", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {

                        if(result != null){
                            imageView.setImageURI(result);
                            imageuri=result;
                        }
                    }
                });

    void savetodatabase(){
        DatabaseReference ref= database.getReference("Events").child("OutsideEvents");
        eventdataholder eventdataholder= new eventdataholder(eventname.getText().toString(),eventdate.getText().toString(),
                eventtime.getText().toString(),contact.getText().toString(),deadline.getText().toString(),description.getText().toString(),
                reglink.getText().toString(),rewards.getText().toString(),venue.getText().toString(),imageuri.toString());
        ref.setValue(eventdataholder);
    }

}