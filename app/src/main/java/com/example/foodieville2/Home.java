package com.example.foodieville2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {

    ImageView mOrder , mReservation, mContact , mProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mOrder= findViewById(R.id.orderImg);
        mReservation = findViewById(R.id.reservationImg);
        mContact = findViewById(R.id.contactImg);
        mProfile = findViewById(R.id.MyProfileImg);

        mOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoOrder = new Intent(Home.this , Order.class);
                startActivity(gotoOrder);
            }
        });

        mReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoReservation = new Intent (Home.this , Reservation.class);
                startActivity(gotoReservation);
            }
        });

        mContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoContact = new Intent (Home.this , Contact.class);
                startActivity(gotoContact);
            }
        });

        mProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoProfile = new Intent(Home.this , MyProfile.class);
                startActivity(gotoProfile);
            }
        });
    }
}
