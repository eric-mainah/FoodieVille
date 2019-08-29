package com.example.foodieville2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Contact extends AppCompatActivity{
    ImageView mCall, mEmail , mWhatsapp , mSms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        mCall = findViewById(R.id.callId);
        mEmail = findViewById(R.id.emailId);
        mSms = findViewById(R.id.smsId);
        mWhatsapp = findViewById(R.id.wozzapId);

     mCall.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             String phone = "+254753569279";
             Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
             startActivity(intent);
         }
     });

        mSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("smsto:+254753569279");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                startActivity(intent);
            }
        });

        mEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","foodieville@gmail.com", null));
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });

        mWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.yowhatsapp");
                startActivity(sendIntent);
            }
        });
    }
}
