package khs.study.youtubesynchronizerandroid.models.player;

/**
 * Created by jaeyoung on 2017. 4. 22..
 */

public class YoutubeSearchResult {
    private String videoId;
    private String thumbnailUrl;
    private String title;
    private String description;

    public YoutubeSearchResult(String videoId, String thumbnailUrl, String title, String description) {
        this.videoId = videoId;
        this.thumbnailUrl = thumbnailUrl;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
