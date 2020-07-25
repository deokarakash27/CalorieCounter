package com.calorieCounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.calorieCounter.preferences.AppSharedPreference;

import static com.calorieCounter.MainActivity.TOTAL_ROTI_EXTRA;

public class RotiActivity extends AppCompatActivity{

    TextView tvTotalRoti;
    private final int totalRoti = 85;
    private int totalCalories = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roti);

        tvTotalRoti = findViewById(R.id.tvTotalRoti);
        Spinner spinner = findViewById(R.id.spinnerRoti);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.Units, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int unit = Integer.parseInt(parent.getItemAtPosition(position).toString());
                totalCalories= totalRoti * unit;

                tvTotalRoti.setText(totalCalories+"");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button btnRotiDone = findViewById(R.id.btnRotiDone);
        btnRotiDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
addDataToPreferences();



                Intent intent = new Intent(RotiActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

private void addDataToPreferences(){

    AppSharedPreference.addKey(TOTAL_ROTI_EXTRA, totalCalories);
}
}
