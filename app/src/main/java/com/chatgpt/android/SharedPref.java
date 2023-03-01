package com.chatgpt.android;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {

//    public static void setDataForRequestedOneTime(Activity activity){
//        SharedPreferences preferences =  activity.getSharedPreferences(AppConstants.SharedPreferences.SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = preferences.edit();
//
//        editor.putBoolean("isRequested",true);
//        editor.apply();
//    }
//
//    public static boolean checkDataForRequestedOneTime(Activity activity){
//        SharedPreferences preferences =  activity.getSharedPreferences(AppConstants.SharedPreferences.SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE);
//        return preferences.getBoolean("isRequested",false);
//    }

    public static void setAppIsOpened(Activity activity){
        SharedPreferences preferences =  activity.getSharedPreferences(AppConstants.SharedPreferences.SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putBoolean("isAppOpenedStatus",true);
        editor.apply();
    }

    public static boolean isAppOpened(Activity activity){
        SharedPreferences preferences =  activity.getSharedPreferences(AppConstants.SharedPreferences.SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE);
        return preferences.getBoolean("isAppOpenedStatus",false);
    }
}
