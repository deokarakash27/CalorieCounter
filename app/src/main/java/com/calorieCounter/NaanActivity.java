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

public class NaanActivity extends AppCompatActivity {

    TextView tvTotalNaan;
    int totalNaan = 149;
    private String source = "";
    private int totalCalories = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naan);

        source = getIntent().getStringExtra(Constant.SOURCE);

        tvTotalNaan = findViewById(R.id.tvTotalNaan);
        Spinner spinner = findViewById(R.id.spinnerNaan);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.Units, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int unit = Integer.parseInt(parent.getItemAtPosition(position).toString());

                totalCalories = totalNaan * unit;

                tvTotalNaan.setText(totalCalories+"");
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                totalCalories = Integer.parseInt(parent.getItemAtPosition(0).toString());

            }
        });


        Button btnNaanDone = findViewById(R.id.btnNaanDone);
        btnNaanDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveCalorieCountToPreferences();

                Intent intent = new Intent(NaanActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void saveCalorieCountToPreferences() {
        switch(source) {
            case Constant.SOURCE_BREAKFAST:
                AppSharedPreference.getInstance().addKey(Constant.BREAKFAST_NAAN, totalCalories);
                break;

            case Constant.SOURCE_LUNCH:
                AppSharedPreference.getInstance().addKey(Constant.LUNCH_NAAN, totalCalories);
                break;

            case Constant.SOURCE_DINNER:
                AppSharedPreference.getInstance().addKey(Constant.DINNER_NAAN, totalCalories);
                break;

            default:
                break;
        }
    }

}
