package khs.study.youtubesynchronizerandroid.ui.player.view;

import java.util.List;

import khs.study.youtubesynchronizerandroid.models.player.VideoItem;

/**
 * Created by jaeyoung on 7/23/17.
 */

public interface PlayerView {
    String getSearchKeyword();

    void clearSearchKeyword();

    void showMessage(String msg);

    void setSearchResults(List<VideoItem> videoItems);

    void setProgress(boolean b);
}
