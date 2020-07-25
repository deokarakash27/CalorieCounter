package com.calorieCounter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.calorieCounter.preferences.AppSharedPreference;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TOTAL_EXTRA = "totalCount";

    public ListView mListViewEatingTimes;
    public String[] mealsArray = {"Breakfast", "Lunch", "Dinner",};
    public ArrayList<String> mListTimes;
    public ArrayAdapter<String> mAdapterTimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListViewEatingTimes = findViewById(R.id.listViewEatingTimes);
        TextView txtTotal = findViewById(R.id.txtTotal);
        txtTotal.setText(AppSharedPreference.getInstance().getTotalCalorieCount()+"");
        mListTimes = new ArrayList<>();
        mAdapterTimes = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mealsArray);
        mListViewEatingTimes.setAdapter(mAdapterTimes);

        mListViewEatingTimes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {

                    Intent intent = new Intent(MainActivity.this, BreakfastActivity.class);
                    startActivity(intent);
                }

                if (position == 1) {

                    Intent intent = new Intent(MainActivity.this, LunchActivity.class);
                    startActivity(intent);
                }

                if (position == 2) {

                    Intent intent = new Intent(MainActivity.this, DinnerActivity.class);
                    startActivity(intent);
                }

            }
        });

    }

}
