package khs.study.youtubesynchronizerandroid.models.login.djangotest;

/**
 * Created by jaeyoung on 2017. 4. 26..
 */

public class User {
    private String username;
    private String email;
    private UserInfo userinfo;
    private String token;
    private String last_name;
    private String first_name;

    private class UserInfo {
        private String age_range;
        private String gender;
        private String pic_url;
    }
}
