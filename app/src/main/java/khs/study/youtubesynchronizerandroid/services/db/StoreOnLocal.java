package khs.study.youtubesynchronizerandroid.services.db;

import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
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

    public List<SearchKeyword> getSearchHistories() {
        List<SearchKeyword> searchKeywords;

        Realm realm = Realm.getDefaultInstance();
        RealmQuery<SearchKeyword> query = realm.where(SearchKeyword.class);

        RealmResults<SearchKeyword> realmResults = query.findAll();
        searchKeywords = realmResults.subList(0, realmResults.size());

        Log.d(TAG, "getSearchHistories: searchKeywords="+searchKeywords.toString());

        return searchKeywords;
    }
}
