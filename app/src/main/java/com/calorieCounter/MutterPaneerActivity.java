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

public class MutterPaneerActivity extends AppCompatActivity {

    TextView tvTotalMutterPaneer;
    int totalMutterPaneer = 167;
    private String source = "";
    private int totalCalories = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutter_paneer);

        source = getIntent().getStringExtra(Constant.SOURCE);

        tvTotalMutterPaneer = findViewById(R.id.tvTotalMutterPaneer);
        Spinner spinner = findViewById(R.id.spinnerMutterPaneer);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.Units, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int unit = Integer.parseInt(parent.getItemAtPosition(position).toString());
                totalCalories = totalMutterPaneer * unit;

                tvTotalMutterPaneer.setText(totalCalories + "");

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                 totalCalories = Integer.parseInt(parent.getItemAtPosition(0).toString());

            }
        });

        Button btnMutterPannerDone = findViewById(R.id.btnMutterPannerDone);
        btnMutterPannerDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveCalorieCountToPreferences();

                Intent intent = new Intent(MutterPaneerActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private void saveCalorieCountToPreferences() {
        switch (source) {
            case Constant.SOURCE_BREAKFAST:
                AppSharedPreference.getInstance().addKey(Constant.BREAKFAST_MUTER_PANNER, totalCalories);
                break;

            case Constant.SOURCE_LUNCH:
                AppSharedPreference.getInstance().addKey(Constant.LUNCH_MUTER_PANNER, totalCalories);
                break;

            case Constant.SOURCE_DINNER:
                AppSharedPreference.getInstance().addKey(Constant.DINNER_MUTER_PANNER, totalCalories);
                break;

            default:
                break;
        }

    }
}