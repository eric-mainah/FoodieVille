package com.example.foodieville2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MyProfile extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        Button mReserve = findViewById(R.id.reserveBtn);
        Button mOrder = findViewById(R.id.orderBtn);
        Button mLogout = findViewById(R.id.logOutBtn);

       /* mReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoReservation = new Intent(MyProfile.this , CartActivity.class);
                startActivity(gotoReservation);
            }
        });*/

        mOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoOrders = new Intent(MyProfile.this , CartActivity.class);
                startActivity(gotoOrders);
            }
        });

         mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
          public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent I = new Intent(MyProfile.this, LogIn.class);
                startActivity(I);
            }
         });

    }
}
