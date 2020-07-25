package com.calorieCounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class BreakfastActivity extends AppCompatActivity {


    private ListView mListViewBreakfastItems;
    private String[] mArrItems = {
            "roti", "naan", "mutterPaneer", "masurDaal",};

    private ArrayList<String> mListItems;
    private ArrayAdapter<String> mAdapterItems;
    int totalOfAllItems = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);

        mListViewBreakfastItems = findViewById(R.id.listViewBreakfasItemst);

        mListItems = new ArrayList<>();

        mAdapterItems = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                mArrItems

        );
        mListViewBreakfastItems.setAdapter(mAdapterItems);

        mListViewBreakfastItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {

                    Intent intent = new Intent(BreakfastActivity.this, RotiActivity.class);
                    intent.putExtra(Constant.SOURCE,Constant.SOURCE_BREAKFAST);
                    startActivityForResult(intent, 100);
                }

                if (position == 1) {

                    Intent intent = new Intent(BreakfastActivity.this, NaanActivity.class);
                    intent.putExtra(Constant.SOURCE,Constant.SOURCE_BREAKFAST);
                    startActivityForResult(intent, 100);

                }

                if (position == 2) {

                    Intent intent = new Intent(BreakfastActivity.this, MutterPaneerActivity.class);
                    intent.putExtra(Constant.SOURCE,Constant.SOURCE_BREAKFAST);
                    startActivityForResult(intent, 100);
                }

                if (position == 3) {

                    Intent intent = new Intent(BreakfastActivity.this, MasurDaalActivity.class);
                    intent.putExtra(Constant.SOURCE,Constant.SOURCE_BREAKFAST);
                    startActivityForResult(intent, 100);
                }

                finish();
            }
        });

    }

}