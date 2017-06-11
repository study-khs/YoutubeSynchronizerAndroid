package khs.study.youtubesynchronizerandroid.utils;

import android.app.Application;
import android.util.Log;

import khs.study.youtubesynchronizerandroid.models.login.Token;

/**
 * Created by jaeyoung on 2017. 6. 11..
 */

public class GlobalApplication extends Application {
    private final String TAG = "JYP/"+getClass().getSimpleName();
    private static GlobalApplication mInstance;

    private Token userToken;

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate: ");
        mInstance = this;
    }

    public static GlobalApplication getInstance() {
        return mInstance;
    }

    public void setUserToken(Token token) {
        userToken = token;
        Log.d(TAG, "setUserToken() called with: token = [" + token + "]");
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
