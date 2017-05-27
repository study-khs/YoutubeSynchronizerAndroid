package khs.study.youtubesynchronizerandroid.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.HashMap;
import java.util.List;

import khs.study.youtubesynchronizerandroid.R;
import khs.study.youtubesynchronizerandroid.utils.consts.KEY;
import khs.study.youtubesynchronizerandroid.models.player.YoutubeSearchResult;
import khs.study.youtubesynchronizerandroid.models.player.HashmapToYoutubeSearchResult;
import khs.study.youtubesynchronizerandroid.utils.retrofit.YoutubeDataApiClient;
import khs.study.youtubesynchronizerandroid.services.network.player.YoutubeDataApiNetwork;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jaeyoung on 2017. 4. 22..
 */

public class PlayerActivity extends Activity {
    private final String TAG = "JYP"+getClass().getSimpleName();
    private YoutubeDataApiClient<YoutubeDataApiNetwork> mClient;
    private YoutubeDataApiNetwork mNetwork;
    private final String youtubeDataApiKey = KEY.getYoutubeDataApiKey();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        initRetrofit();

        search("성시경");
    }

    private void search(String q) {
        Call<HashMap> call = mNetwork.getSearchResults(q,youtubeDataApiKey);
        call.enqueue(new Callback<HashMap>() {
            @Override
            public void onResponse(Call<HashMap> call, Response<HashMap> response) {
                Log.d(TAG, "onResponse: ");

                List<YoutubeSearchResult> youtubeSearchResults = HashmapToYoutubeSearchResult.convert(response.body());
                Log.d(TAG, "onResponse: "+youtubeSearchResults.toString());
            }

            @Override
            public void onFailure(Call<HashMap> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });
    }

    private void initRetrofit() {
        mClient = new YoutubeDataApiClient<>();
        mNetwork = mClient.getClient(
                YoutubeDataApiNetwork.class);
    }
}
