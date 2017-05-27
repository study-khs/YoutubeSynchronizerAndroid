package khs.study.youtubesynchronizerandroid.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.google.firebase.FirebaseApp;

import khs.study.youtubesynchronizerandroid.R;
import khs.study.youtubesynchronizerandroid.services.StoreOnFirebase;
import khs.study.youtubesynchronizerandroid.services.YoutubeSearch;

/**
 * Created by jaeyoung on 2017. 4. 22..
 */

public class PlayerActivity extends Activity {
    private final String TAG = "JYP"+getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        YoutubeSearch.search("성시경");
        StoreOnFirebase.storeSearchHistory("성시굥");
        StoreOnFirebase.storeAppTurnedOnAt();
    }
}
