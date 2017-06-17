package khs.study.youtubesynchronizerandroid.models.player.db;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by jaeyoung on 2017. 6. 17..
 */
public class SearchKeyword extends RealmObject {
    private String keyword;
    private Date lastestSearchAt;
    private int searchCount;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Date getLastestSearchAt() {
        return lastestSearchAt;
    }

    public void setLastestSearchAt(Date lastestSearchAt) {
        this.lastestSearchAt = lastestSearchAt;
    }

    public int getSearchCount() {
        return searchCount;
    }

    public void setSearchCount(int searchCount) {
        this.searchCount = searchCount;
    }

    @Override
    public String toString() {
        return "SearchKeyword{" +
                "keyword='" + keyword + '\'' +
                ", lastestSearchAt=" + lastestSearchAt +
                ", searchCount=" + searchCount +
                '}';
    }
}
