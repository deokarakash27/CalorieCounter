package com.calorieCounter.preferences;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.calorieCounter.application.CaloryApplication;

public class AppSharedPreference {


    private static SharedPreferences mPreferences;
    private static SharedPreferences.Editor mEditor;


    public static void addKey(String key,int value){
        mPreferences = PreferenceManager.getDefaultSharedPreferences(CaloryApplication.getContext());
        mEditor = mPreferences.edit();
        mEditor.putInt(key, value);
        mEditor.commit();
    }

    public static int retrieveKey(String key){
        mPreferences = PreferenceManager.getDefaultSharedPreferences(CaloryApplication.getContext());
        return mPreferences.getInt(key,0);
    }

    public static void clear(){
        mPreferences = PreferenceManager.getDefaultSharedPreferences(CaloryApplication.getContext());
        mEditor = mPreferences.edit();
        mEditor.clear();
        mEditor.commit();
    }

}
