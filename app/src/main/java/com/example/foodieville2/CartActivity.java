package com.example.foodieville2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class CartActivity extends AppCompatActivity {
ListView list;
CustomAdapterOrder orderAdapter;
ArrayList<Dishi>order;
ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        list = findViewById(R.id.listOrder);
        order = new ArrayList<>();
        orderAdapter = new CustomAdapterOrder(this , order);
        dialog = new ProgressDialog(this );
        dialog.setTitle("Loading ");
        dialog.setMessage("Please wait ....");

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Order");
        dialog.show();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                order.clear();
                for (DataSnapshot snap : dataSnapshot.getChildren()) {
                    Dishi y = snap.getValue(Dishi.class);
                    order.add(y);
                    Collections.reverse(order);
                    orderAdapter.notifyDataSetChanged();
                }
                dialog.dismiss();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(CartActivity.this, "Please contact your service provider", Toast.LENGTH_SHORT).show();
            }
        });

        list.setAdapter(orderAdapter);
    }
}
