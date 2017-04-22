package khs.study.youtubesynchronizerandroid.player.model;

import android.util.Log;

import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import khs.study.youtubesynchronizerandroid.player.domain.YoutubeSearchResult;

/**
 * Created by jaeyoung on 2017. 4. 22..
 */

public class HashmapToYoutubeSearchResult {
    public static List<YoutubeSearchResult> convert(HashMap rawResult) {
        ArrayList<LinkedTreeMap> arr = (ArrayList<LinkedTreeMap>) rawResult.get("items");
        ArrayList<YoutubeSearchResult> results = new ArrayList<>();
        for (LinkedTreeMap each:
                arr) {
            String videoId = (String) ((LinkedTreeMap) each.get("id")).get("videoId");
            String thumbnailUrl =(String) ((LinkedTreeMap) ((LinkedTreeMap) ((LinkedTreeMap) each.get("snippet")).get("thumbnails")).get("default")).get("url");
            String title = (String) ((LinkedTreeMap) each.get("snippet")).get("title");
            String description = (String) ((LinkedTreeMap) each.get("snippet")).get("description");
            results.add(new YoutubeSearchResult(videoId, thumbnailUrl, title, description));
        }

        return results;
    }
}
