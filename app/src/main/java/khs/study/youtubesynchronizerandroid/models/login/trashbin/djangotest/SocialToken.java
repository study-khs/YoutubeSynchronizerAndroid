package khs.study.youtubesynchronizerandroid.models.login.trashbin.djangotest;

/**
 * Created by jaeyoung on 2017. 4. 26..
 */

public class SocialToken {
    String type;
    String token;

    public SocialToken(String type, String token) {
        this.type = type;
        this.token = token;
    }
}