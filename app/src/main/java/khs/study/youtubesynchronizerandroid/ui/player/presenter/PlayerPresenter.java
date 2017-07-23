package khs.study.youtubesynchronizerandroid.ui.player.presenter;

import android.util.Log;

import java.util.List;

import khs.study.youtubesynchronizerandroid.models.player.VideoItem;
import khs.study.youtubesynchronizerandroid.models.player.YoutubeSearchResult;
import khs.study.youtubesynchronizerandroid.services.YoutubeSearch;
import khs.study.youtubesynchronizerandroid.ui.player.view.PlayerView;
import khs.study.youtubesynchronizerandroid.utils.converter.YoutubeSearchResult2VideoItem;

/**
 * Created by jaeyoung on 7/22/17.
 */

public class PlayerPresenter {
    private static final String TAG = "PlayerPresenter";
    private final String NOKEYWORD_ERROR = "키워드를 입력해주세요.";
    private final PlayerView mPlayerView;

    public PlayerPresenter(PlayerView playerView) {
        Log.d(TAG, "PlayerPresenter: ");
        this.mPlayerView = playerView;
    }

    public void searchClicked() {
        searchKeyword();
    }

    private void searchKeyword() {
        String keyword = mPlayerView.getSearchKeyword();
        if (keyword.length() > 0) {
            mPlayerView.clearSearchKeyword();
            mPlayerView.setProgress(true);
            searchKeyword(keyword);
        } else {
            mPlayerView.showMessage(NOKEYWORD_ERROR);
        }
    }

    private void searchKeyword(String keyword) {
        Log.d(TAG, "searchKeyword() called with: keyword = [" + keyword + "]");
        YoutubeSearch.getInstance().search(keyword,
                results -> {
                    Log.d(TAG, "onCreate: " + results);
                    List<YoutubeSearchResult> youtubeSearchResults = results;

                    List<VideoItem> videoItems = YoutubeSearchResult2VideoItem.youtubeSearchResult2VideoItem(youtubeSearchResults);
                    mPlayerView.setSearchResults(videoItems);
                    mPlayerView.setProgress(false);
                }
        );
    }
}
