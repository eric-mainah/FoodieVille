package com.example.foodieville2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Order extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        final Spinner spinner = findViewById(R.id.fastfoodSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.fastfood, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        final Spinner spinner2 = findViewById(R.id.drinksSpinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.drinks, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        Button save = findViewById(R.id.saveBtn);
        final EditText name = findViewById(R.id.orderNameText);
        final ProgressDialog dialog =  new ProgressDialog(this );
        dialog.setTitle("Loading ");
        dialog.setMessage("Please wait ....");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
                String jina = name.getText().toString();
                String food = spinner.getSelectedItem().toString();
                String drinks = spinner2.getSelectedItem().toString();
                long Time = System.currentTimeMillis();
                String timeconvert = String.valueOf(Time);

                if (food.isEmpty()||jina.isEmpty()) {
                    Toast.makeText(Order.this, "Fill in the required positions", Toast.LENGTH_SHORT).show();
                } else {
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Order/" + timeconvert);
                    Dishi y = new Dishi(jina ,food, drinks);
                    ref.setValue(y).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                dialog.dismiss();
                                Toast.makeText(Order.this, "Order placed Successfully", Toast.LENGTH_SHORT).show();
                                Intent gotocart = new Intent(Order.this ,  Home.class);
                                startActivity(gotocart);
                            } else {
                                Toast.makeText(Order.this, "Order not placed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
