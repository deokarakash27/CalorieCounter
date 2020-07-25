package com.calorieCounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MasurDaalActivity extends AppCompatActivity {

    TextView tvTotalMasurDaal;
    int totalMasurDaal = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masur_daal);

        tvTotalMasurDaal = findViewById(R.id.tvTotalMasurDaal);
        Spinner spinner = findViewById(R.id.spinnerMasurDaal);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.Units, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int unit = Integer.parseInt(parent.getItemAtPosition(position).toString());
                int i =  totalMasurDaal * unit;

                tvTotalMasurDaal.setText(i+"");

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

}
