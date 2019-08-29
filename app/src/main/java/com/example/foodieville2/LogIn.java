package com.example.foodieville2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogIn extends AppCompatActivity {
    EditText mEmail,mPassword;
    Button save;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthstatelistener;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mEmail = findViewById(R.id.emailtext);
        mPassword = findViewById(R.id.passwordtext);
        dialog = new ProgressDialog(this);
        mFirebaseAuth = FirebaseAuth.getInstance();
        save = findViewById(R.id.button2);
        dialog.setTitle("Saving ");
        dialog.setMessage("Connecting to servers.Please Wait...");

        mAuthstatelistener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = mFirebaseAuth.getCurrentUser();
                if( user != null){
                    Toast.makeText(LogIn.this, "User is logged in ", Toast.LENGTH_SHORT).show();
                    Intent gotoHome = new Intent (LogIn.this , Home.class);
                    gotoHome.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(gotoHome);
                }else{
                    Toast.makeText(LogIn.this, "Login to continue", Toast.LENGTH_SHORT).show();
                }
            }
        };
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();
                
                if(email.isEmpty() || password.isEmpty()){
                    Toast.makeText(LogIn.this, "Please fill in the empty field(s)", Toast.LENGTH_SHORT).show();
                }else{
                    mFirebaseAuth.signInWithEmailAndPassword(email , password).addOnCompleteListener(LogIn.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(LogIn.this, "Log in successfull", Toast.LENGTH_SHORT).show();
                                Intent gotoHome = new Intent (LogIn.this , Home.class);
                                startActivity(gotoHome);
                            }else{
                                Toast.makeText(LogIn.this, "Log in Unsuccessfull", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
