package khs.study.youtubesynchronizerandroid.services;

import android.util.Log;

import java.util.HashMap;
import java.util.List;

import io.reactivex.functions.Consumer;
import khs.study.youtubesynchronizerandroid.models.player.HashmapToYoutubeSearchResult;
import khs.study.youtubesynchronizerandroid.models.player.YoutubeSearchResult;
import khs.study.youtubesynchronizerandroid.services.db.StoreOnFirebase;
import khs.study.youtubesynchronizerandroid.services.network.player.YoutubeDataApiNetwork;
import khs.study.youtubesynchronizerandroid.utils.consts.KEY;
import khs.study.youtubesynchronizerandroid.utils.retrofit.YoutubeDataApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jaeyoung on 2017. 5. 27..
 */

public class YoutubeSearch {
    private static final String TAG = "YoutubeSearch";
    private static YoutubeSearch mInstance;

    public static YoutubeSearch getInstance() {
        synchronized (YoutubeSearch.class) {
            if (mInstance == null) {
                mInstance = new YoutubeSearch();
            }
        }
        return mInstance;
    }

    public void search(String q, Consumer<List<YoutubeSearchResult>> finished) {
        String youtubeDataApiKey = KEY.getYoutubeDataApiKey();

        YoutubeDataApiClient<YoutubeDataApiNetwork> mClient;
        mClient = new YoutubeDataApiClient<>();
        YoutubeDataApiNetwork mNetwork = mClient.getClient(
                YoutubeDataApiNetwork.class);

        Call<HashMap> call = mNetwork.getSearchResults(q, youtubeDataApiKey);
        call.enqueue(new Callback<HashMap>() {
            @Override
            public void onResponse(Call<HashMap> call, Response<HashMap> response) {
                Log.d(TAG, "onResponse: ");

                List<YoutubeSearchResult> youtubeSearchResults = HashmapToYoutubeSearchResult.convert(response.body());
                Log.d(TAG, "onResponse: "+youtubeSearchResults.toString());
                saveSearchKeywordHistory(q);
                try {
                    finished.accept(youtubeSearchResults);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<HashMap> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });
    }

    private void saveSearchKeywordHistory(String q) {
        Log.d(TAG, "saveSearchKeywordHistory() called with: q = [" + q + "]");
        StoreOnFirebase.storeSearchHistory(q);
    }
}
