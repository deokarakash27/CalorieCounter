package com.calorieCounter.preferences;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.calorieCounter.Constant;
import com.calorieCounter.application.CaloryApplication;

public class AppSharedPreference {


    private static SharedPreferences mPreferences;
    private static SharedPreferences.Editor mEditor;

    public static AppSharedPreference instance;

    private AppSharedPreference(){
        super();
    }

    public static AppSharedPreference getInstance() {
        if (instance == null) {
            instance = new AppSharedPreference();
            mPreferences = PreferenceManager.getDefaultSharedPreferences(CaloryApplication.getContext());
            mEditor = mPreferences.edit();
        }

        return instance;
    }

    public static void addKey(String key, int value) {
        Log.e("AppSharedPreference","Key="+key+" Value="+value);
        mEditor.putInt(key, value);
        mEditor.commit();
        Log.e("AppSharedPreference",getTotalCalorieCount()+"");
    }

    private static int retrieveKey(String key) {
        return mPreferences.getInt(key, 0);
    }

    public static void clear() {
        mEditor.clear();
        mEditor.commit();
    }

    public static int getTotalCalorieCount() {
        return  retrieveKey(Constant.BREAKFAST_ROTI) +
                retrieveKey(Constant.BREAKFAST_NAAN) +
                retrieveKey(Constant.BREAKFAST_MUTER_PANNER) +
                retrieveKey(Constant.BREAKFAST_MASUR_DAAL) +

                retrieveKey(Constant.LUNCH_ROTI) +
                retrieveKey(Constant.LUNCH_NAAN) +
                retrieveKey(Constant.LUNCH_MUTER_PANNER) +
                retrieveKey(Constant.LUNCH_MASUR_DAAL) +

                retrieveKey(Constant.DINNER_ROTI) +
                retrieveKey(Constant.DINNER_NAAN) +
                retrieveKey(Constant.DINNER_MUTER_PANNER) +
                retrieveKey(Constant.DINNER_MASUR_DAAL);
        }

    }
