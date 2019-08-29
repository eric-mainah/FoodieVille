package com.example.foodieville2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
EditText mName,mEmail,mPassword;
Button save;
FirebaseAuth mFirebaseAuth;
ProgressDialog dialog;
TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName= findViewById(R.id.nameText);
        mEmail= findViewById(R.id.emailtext);
        mPassword= findViewById(R.id.passwordtext);
        login = findViewById(R.id.loginText);
        dialog = new ProgressDialog(this);

        mFirebaseAuth = FirebaseAuth.getInstance();
        save=findViewById(R.id.button);
        dialog.setTitle("Saving ");
        dialog.setMessage("Connecting to servers.Please Wait...");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mName.getText().toString();
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();

                if(name.isEmpty() || email.isEmpty() || password.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Fill in the empty field(s)", Toast.LENGTH_SHORT).show();
                }else{
                    dialog.show();
                    mFirebaseAuth.createUserWithEmailAndPassword(email , password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                dialog.dismiss();
                                Intent gotoHome = new Intent(MainActivity.this , Home.class);
                                startActivity(gotoHome);
                                Toast.makeText(MainActivity.this, "Welcome to Foodieville", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(MainActivity.this, "Sign up not Successfull", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoLogin = new Intent(MainActivity.this , LogIn.class);
                startActivity(gotoLogin);
            }
        });
    }
}
