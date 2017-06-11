package khs.study.youtubesynchronizerandroid.models.login;

import lombok.Data;

/**
 * Created by jaeyoung on 2017. 6. 11..
 */

public class Token {
    private String authorizationToken;

    public String getAuthorizationToken() {
        return authorizationToken;
    }

    public void setAuthorizationToken(String authorizationToken) {
        this.authorizationToken = authorizationToken;
    }

    @Override
    public String toString() {
        return "Token{" +
                "authorizationToken='" + authorizationToken + '\'' +
                '}';
    }
}
