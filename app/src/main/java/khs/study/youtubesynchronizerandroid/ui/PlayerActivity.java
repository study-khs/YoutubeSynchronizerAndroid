package khs.study.youtubesynchronizerandroid.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import khs.study.youtubesynchronizerandroid.R;
import khs.study.youtubesynchronizerandroid.services.db.StoreOnFirebase;
import khs.study.youtubesynchronizerandroid.services.YoutubeSearch;
import khs.study.youtubesynchronizerandroid.services.db.StoreOnLocal;

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

        StoreOnLocal.getInstance().storeSearchHistory("성시굥");

        StoreOnFirebase.storeAppTurnedOnAt();
    }
}
