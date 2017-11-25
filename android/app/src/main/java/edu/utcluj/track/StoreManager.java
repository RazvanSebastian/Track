package edu.utcluj.track;

import android.content.Context;
import android.preference.PreferenceManager;

/**
 * Created by Parautiu on 25.11.2017.
 */

public class StoreManager {

    private static final String TOKEN_IDENTIFIER = "deviceToken";

    public static boolean storeToken(Context context ,String deviceToken){
        return PreferenceManager.getDefaultSharedPreferences(context).edit().putString(TOKEN_IDENTIFIER, deviceToken).commit();
    }

    public static String readToken(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context).getString(TOKEN_IDENTIFIER, "tokenNotFound");
    }

}
