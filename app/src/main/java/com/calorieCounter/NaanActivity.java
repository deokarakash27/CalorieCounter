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

public class NaanActivity extends AppCompatActivity {

    TextView tvTotalNaan;
    int totalNaan = 149;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naan);

        tvTotalNaan = findViewById(R.id.tvTotalNaan);
        Spinner spinner = findViewById(R.id.spinnerNaan);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.Units, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int unit = Integer.parseInt(parent.getItemAtPosition(position).toString());
                int i = totalNaan * unit;
                tvTotalNaan.setText(i+"");
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Button btnNaanDone = findViewById(R.id.btnNaanDone);
        btnNaanDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NaanActivity.this, MainActivity.class);
                intent.putExtra("totalNaan", totalNaan);
                startActivity(intent);
                finish();
            }
        });

    }

}
