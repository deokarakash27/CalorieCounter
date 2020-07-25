package com.calorieCounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class LunchActivity extends AppCompatActivity {

    public static final String TOTAL_LUNCH_ROTI = "totalLunchRoti";
    public static final String TOTAL_LUNCH_NAAN = "totalLunchtNaan";
    public static final String TOTAL_LUNCH_MUTTERPANEER = "totalLunchMutterPaneer";
    public static final String TOTAL_LUNCH_MASURDAAL = "totalLunchMasurDaal";

    private ListView mListViewLunchItems;
    private String [] mArrItems = {
            "roti", "naan", "mutterPaneer", "masurDaal", };
    private ArrayList<String> mListItems;
    private ArrayAdapter<String> mAdapterItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);

        mListViewLunchItems = findViewById( R.id.listViewLunchItems );

        mListItems = new ArrayList<>();

        mAdapterItems = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                mArrItems

        );
        mListViewLunchItems.setAdapter( mAdapterItems );

        mListViewLunchItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position==0){

                    Intent intent = new Intent(LunchActivity.this, RotiActivity.class);
                    startActivityForResult(intent, 100);
                }

                if (position==1){

                    Intent intent = new Intent(LunchActivity.this, NaanActivity.class);
                    startActivityForResult(intent,100);
                }

                if (position==2){

                    Intent intent = new Intent(LunchActivity.this, MutterPaneerActivity.class);
                    startActivityForResult(intent,100);
                }

                if (position==3){

                    Intent intent = new Intent(LunchActivity.this, MasurDaalActivity.class);
                    startActivityForResult(intent,100);
                }
            }
        });

    }
}
