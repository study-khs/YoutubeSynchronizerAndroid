package khs.study.youtubesynchronizerandroid.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import khs.study.youtubesynchronizerandroid.R;
import khs.study.youtubesynchronizerandroid.services.db.StoreOnFirebase;
import khs.study.youtubesynchronizerandroid.services.YoutubeSearch;
import khs.study.youtubesynchronizerandroid.utils.youtube.DeveloperKey;
import khs.study.youtubesynchronizerandroid.utils.youtube.YouTubeFailureRecoveryActivity;

/**
 * Created by jaeyoung on 2017. 4. 22..
 */

public class PlayerActivity extends YouTubeFailureRecoveryActivity {
    private final String TAG = "JYP"+getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        YoutubeSearch.search("성시경");
        StoreOnFirebase.storeSearchHistory("성시굥");
        StoreOnFirebase.storeAppTurnedOnAt();

        YouTubePlayerView youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(DeveloperKey.DEVELOPER_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player,
                                        boolean wasRestored) {
        if (!wasRestored) {
            player.cueVideo("wKJ9KzGQq0w");
        }
    }

    @Override
    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.youtube_view);
    }
}
