package khs.study.youtubesynchronizerandroid.domain;

import java.io.Serializable;

/**
 * Created by jaeyoung on 2017. 4. 15..
 */

public class UserJoinWithFacebookRequestDto implements Serializable {
    private String type;
    private String token;

    public UserJoinWithFacebookRequestDto(String type, String token) {
        this.type = type;
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
