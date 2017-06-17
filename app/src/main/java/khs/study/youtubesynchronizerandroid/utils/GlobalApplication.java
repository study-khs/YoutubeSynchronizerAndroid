package khs.study.youtubesynchronizerandroid.utils;

import android.app.Application;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import khs.study.youtubesynchronizerandroid.models.login.Token;
import khs.study.youtubesynchronizerandroid.utils.realm.SchemaModule;

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

        initRealm();
    }

    private void initRealm() {
        Log.d(TAG, "initRealm: ");
        Realm.init(this);
//
//        byte[] key = new byte[64];
//        new SecureRandom().nextBytes(key);
        int schemaVersion = 0;
//
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("youtubesynchronizer_realm.realm")
//                .encryptionKey(key)
                .schemaVersion(schemaVersion)
                .modules(new SchemaModule())
//                .migration(new MyMigration())
                .build();
//
        Realm.setDefaultConfiguration(config);
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
