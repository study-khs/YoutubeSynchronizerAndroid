package khs.study.youtubesynchronizerandroid.utils.converter;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import khs.study.youtubesynchronizerandroid.models.player.VideoItem;
import khs.study.youtubesynchronizerandroid.models.player.YoutubeSearchResult;

/**
 * Created by jaeyoung on 7/23/17.
 */

public class YoutubeSearchResult2VideoItem {
    private static final String TAG = "YoutubeSearchResult2Vid";

    public static List<VideoItem> youtubeSearchResult2VideoItem(List<YoutubeSearchResult> youtubeSearchResults) {
        List<VideoItem> videoItems = new ArrayList<>();
        for (YoutubeSearchResult youtubeSearchResult:
        youtubeSearchResults) {
            String thumbnailUrl = youtubeSearchResult.getThumbnailUrl();
            String title = youtubeSearchResult.getTitle();
            String cueId = youtubeSearchResult.getVideoId();
            VideoItem videoItem = new VideoItem(thumbnailUrl, title, cueId);
            videoItems.add(videoItem);
        }

        Log.d(TAG, "youtubeSearchResult2VideoItem() called with: " +
                "youtubeSearchResults.size() = [" + youtubeSearchResults.size() + "]");
        Log.d(TAG, "youtubeSearchResult2VideoItem() called with: " +
                "videoItems.size() = [" + videoItems.size() + "]");
        return videoItems;
    }
}
