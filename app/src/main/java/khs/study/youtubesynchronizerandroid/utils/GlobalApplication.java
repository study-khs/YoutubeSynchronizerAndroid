package khs.study.youtubesynchronizerandroid.utils;

import android.app.Application;

import khs.study.youtubesynchronizerandroid.models.login.Token;

/**
 * Created by jaeyoung on 2017. 6. 11..
 */

public class GlobalApplication extends Application {
    private static GlobalApplication mInstance;

    private Token userToken;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
    }

    public static GlobalApplication getInstance() {
        return mInstance;
    }

    public void setUserToken(Token token) {
        userToken = token;
    }

    public Token getUserToken() {
        return userToken;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        mInstance = null;
    }
}
