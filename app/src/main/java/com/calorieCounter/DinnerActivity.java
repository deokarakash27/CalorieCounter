package com.calorieCounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DinnerActivity extends AppCompatActivity {

    private ListView mListViewDinnerItems;
    private String [] mArrItems = {
            "roti", "naan", "mutterPaneer", "masurDaal", };
    private ArrayList<String> mListItems;
    private ArrayAdapter<String> mAdapterItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner);

        mListViewDinnerItems = findViewById( R.id.listViewDinnerItems );

        mListItems = new ArrayList<>();

        mAdapterItems = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                mArrItems

        );
        mListViewDinnerItems.setAdapter( mAdapterItems );


        mListViewDinnerItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position==0){

                    Intent intent = new Intent(DinnerActivity.this, RotiActivity.class);
                    startActivity(intent);
                }

                if (position==1){

                    Intent intent = new Intent(DinnerActivity.this, NaanActivity.class);
                    startActivity(intent);
                }

                if (position==2){

                    Intent intent = new Intent(DinnerActivity.this, MutterPaneerActivity.class);
                    startActivity(intent);
                }

                if (position==3){

                    Intent intent = new Intent(DinnerActivity.this, MasurDaalActivity.class);
                    startActivity(intent);
                }

            }
        });
    }
}
