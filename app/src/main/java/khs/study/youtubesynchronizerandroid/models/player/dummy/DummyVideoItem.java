package khs.study.youtubesynchronizerandroid.models.player.dummy;

import java.util.ArrayList;
import java.util.List;

import khs.study.youtubesynchronizerandroid.models.player.VideoItem;

/**
 * Created by jaeyoung on 7/22/17.
 */

public class DummyVideoItem {
    public static List<VideoItem> getDummyVideoItems() {
        List<VideoItem> dummy = new ArrayList<>();
        dummy.add(new VideoItem("url", "title1videotitle", "cueid"));
        dummy.add(new VideoItem("url", "title2videotitle", "cueid"));
        dummy.add(new VideoItem("url", "title3videotitle", "cueid"));
        dummy.add(new VideoItem("url", "title4videotitle", "cueid"));
        dummy.add(new VideoItem("url", "title5videotitle", "cueid"));
        dummy.add(new VideoItem("url", "title6videotitle", "cueid"));

        return dummy;
    }
}
