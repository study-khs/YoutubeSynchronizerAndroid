package khs.study.youtubesynchronizerandroid.services.db;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.internal.LinkedTreeMap;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by jaeyoung on 2017. 5. 27..
 */

public class StoreOnFirebase {
    private static String TAG = "JYP/StoreOnFirebase";
    private static DatabaseReference mRef = null;

    public static void storeSearchHistory(String keyword) {
        Log.d(TAG, "storeSearchHistory() called with: keyword = [" + keyword + "]");

        HashMap<String,String> map = new HashMap<>();
        map.put("keyword", keyword);
        DatabaseReference ref = getRef();
        ref.child("SearchHistory").push().setValue(map);
    }

    private static DatabaseReference getRef() {
        if(mRef == null) {
            Log.d(TAG, "getRef: initialize");
            FirebaseDatabase db = FirebaseDatabase.getInstance();
            mRef = db.getReference("users").child("JYP");
        }

        return mRef;
    }
    
    public static void storeAppTurnedOnAt() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat ssNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String result = ssNow.format(date);

        HashMap<String,String> map = new HashMap<>();
        map.put("AppTurnedOnAt", result);
        DatabaseReference ref = getRef();
        ref.child("AppTurnedOnAt").push().setValue(map);

        Log.d(TAG, "storeAppTurnedOnAt: "+result);
    }
}
