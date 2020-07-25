package com.calorieCounter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.calorieCounter.preferences.AppSharedPreference;

public class RotiActivity extends AppCompatActivity {


    private final int totalRoti = 85;
    TextView tvTotalRoti;
    private int totalCalories = 0;
    private String source = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roti);

        source = getIntent().getStringExtra(Constant.SOURCE);

        tvTotalRoti = findViewById(R.id.tvTotalRoti);
        Spinner spinner = findViewById(R.id.spinnerRoti);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.Units, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int unit = Integer.parseInt(parent.getItemAtPosition(position).toString());
                totalCalories = totalRoti * unit;

                tvTotalRoti.setText(totalCalories + "");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                totalCalories = Integer.parseInt(parent.getItemAtPosition(0).toString());

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

    private void addDataToPreferences() {

        switch (source) {
            case Constant.SOURCE_BREAKFAST:
                AppSharedPreference.getInstance().addKey(Constant.BREAKFAST_ROTI, totalCalories);
                break;

            case Constant.SOURCE_LUNCH:
                AppSharedPreference.getInstance().addKey(Constant.LUNCH_ROTI, totalCalories);
                break;

            case Constant.SOURCE_DINNER:
                AppSharedPreference.getInstance().addKey(Constant.DINNER_ROTI, totalCalories);
                break;

            default:
                break;
        }


    }
}
