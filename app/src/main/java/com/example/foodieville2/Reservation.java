package com.example.foodieville2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.Calendar;


public class Reservation extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TimePickerDialog picker;
    EditText eText, name, time;
    Button Save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

         final Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.table_number, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        final Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.sittingarea, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        Save = findViewById(R.id.button4);
        name = findViewById(R.id.resNametext);
        time = findViewById(R.id.resTimetext);

        eText = findViewById(R.id.resTimetext);
        eText.setInputType(InputType.TYPE_NULL);

        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int hour = cldr.get(Calendar.HOUR_OF_DAY);
                int minutes = cldr.get(Calendar.MINUTE);

                picker = new TimePickerDialog(Reservation.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                eText.setText(sHour + ":" + sMinute);
                            }
                        }, hour, minutes, true);
                picker.show();
            }
        });


        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jina = name.getText().toString();
                String saa = time.getText().toString();
                String meza = spinner.getSelectedItem().toString();
                String meza2 = spinner2.getSelectedItem().toString();
                long Time = System.currentTimeMillis();
                String timeconvert = String.valueOf(Time);

                if (jina.isEmpty() || saa.isEmpty() || meza.isEmpty() || meza2.isEmpty()) {
                    Toast.makeText(Reservation.this, "Fill in the required information", Toast.LENGTH_SHORT).show();
                } else {
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Reservation/"+timeconvert);
                    Item x = new Item(jina, saa, meza, meza2);
                    ref.setValue(x).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Reservation.this, "Reservation made Successfully", Toast.LENGTH_SHORT).show();
                                Intent gotohome = new Intent (Reservation.this , Home.class);
                                startActivity(gotohome);
                            } else {
                                Toast.makeText(Reservation.this, "Reservation not made", Toast.LENGTH_SHORT).show();
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
