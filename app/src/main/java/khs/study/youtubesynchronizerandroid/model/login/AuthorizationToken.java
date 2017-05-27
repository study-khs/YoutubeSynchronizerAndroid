package khs.study.youtubesynchronizerandroid.model.login;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jaeyoung on 2017. 4. 15..
 */

public class AuthorizationToken implements Serializable {
    @SerializedName("authorizationToken")
    private String authorizationToken;

    public AuthorizationToken(String authorizationToken) {
        this.authorizationToken = authorizationToken;
    }

    public String getAuthorizationToken() {
        return authorizationToken;
    }

    public void setAuthorizationToken(String authorizationToken) {
        this.authorizationToken = authorizationToken;
    }
}