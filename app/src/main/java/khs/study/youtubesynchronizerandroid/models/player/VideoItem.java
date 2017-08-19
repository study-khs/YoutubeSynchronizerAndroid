package khs.study.youtubesynchronizerandroid.models.player;

import java.io.Serializable;

/**
 * Created by jaeyoung on 7/22/17.
 */

public class VideoItem implements Serializable {
    private String thumbnailUrl;
    private String title;
    private String cueId;

    public VideoItem() {
    }

    public VideoItem(String thumbnailUrl, String title, String cueId) {
        this.thumbnailUrl = thumbnailUrl;
        this.title = title;
        this.cueId = cueId;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCueId() {
        return cueId;
    }

    public void setCueId(String cueId) {
        this.cueId = cueId;
    }

    @Override
    public String toString() {
        return "VideoItem{" +
                "thumbnailUrl='" + thumbnailUrl + '\'' +
                ", title='" + title + '\'' +
                ", cueId='" + cueId + '\'' +
                '}';
    }
}
