package com.example.navbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.navbar.ui.home.HomeFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {
    EditText mail, pass, name;
    Button btn,btn1;
    FirebaseAuth auth;
    String mailtxt, passtxt, nametxt;
    FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name = findViewById(R.id.name1);
        mail = findViewById(R.id.mail1);
        pass = findViewById(R.id.pass1);
        btn = findViewById(R.id.loginopen1);
        btn1= findViewById(R.id.organize);
        auth= FirebaseAuth.getInstance();
        firebaseDatabase= FirebaseDatabase.getInstance();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), login.class));
            }
        });
    }
        public void registerUsers (View view){

            nametxt = name.getText().toString();
            mailtxt = mail.getText().toString();
            passtxt = pass.getText().toString();

            auth.createUserWithEmailAndPassword(mailtxt,passtxt).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        savetodatabase();
                        Toast.makeText(getApplicationContext(), "User Added", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),NavbarActivity.class));
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "User Not Added", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

    void savetodatabase(){
        String userid= auth.getCurrentUser().getUid();
        DatabaseReference ref= firebaseDatabase.getReference("Users").child(userid);
        Users u = new Users(nametxt,mailtxt,passtxt,"","", "");
        ref.setValue(u);
    }
}