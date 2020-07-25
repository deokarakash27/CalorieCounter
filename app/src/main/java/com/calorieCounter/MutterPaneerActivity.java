package com.calorieCounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MutterPaneerActivity extends AppCompatActivity {

    TextView tvTotalMutterPaneer;
    int totalMutterPaneer = 167;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutter_paneer);

        tvTotalMutterPaneer = findViewById(R.id.tvTotalMutterPaneer);
        Spinner spinner = findViewById(R.id.spinnerMutterPaneer);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.Units, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int unit = Integer.parseInt(parent.getItemAtPosition(position).toString());
                int i =  totalMutterPaneer * unit;

                tvTotalMutterPaneer.setText(i+"");

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

}
