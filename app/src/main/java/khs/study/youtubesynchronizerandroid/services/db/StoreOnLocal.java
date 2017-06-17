package khs.study.youtubesynchronizerandroid.services.db;

import android.util.Log;

import java.util.Date;

import io.realm.Realm;
import khs.study.youtubesynchronizerandroid.models.player.db.SearchKeyword;

/**
 * Created by jaeyoung on 2017. 6. 17..
 */

public class StoreOnLocal {
    private final String TAG = "jaeyoung/"+getClass().getSimpleName();
    private static StoreOnLocal mInstance;

    public static StoreOnLocal getInstance() {
        if (mInstance == null) {
            mInstance = new StoreOnLocal();
        }
        
        return mInstance;
    }

    public void storeSearchHistory(String keyword) {
        Log.d(TAG, "storeSearchHistory() called with: keyword = [" + keyword + "]");

        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        SearchKeyword searchKeyword = new SearchKeyword();
        searchKeyword.setKeyword(keyword);
        Date currentDate = new Date();
        searchKeyword.setLastestSearchAt(currentDate);
        int searchCount = 1;
        searchKeyword.setSearchCount(searchCount);

        realm.commitTransaction();
    }
}
