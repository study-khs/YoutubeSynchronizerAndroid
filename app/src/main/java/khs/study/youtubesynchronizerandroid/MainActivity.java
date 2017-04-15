package khs.study.youtubesynchronizerandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "JYP/"+getClass().getSimpleName();
    private LoginButton mFacebookLoginBtn;
    private CallbackManager callbackManager;

    private String facebookToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // facebook init
        initFacebookLogin();
    }

    private void initFacebookLogin() {
        Log.d(TAG, "initFacebookLogin: ");

        FacebookSdk.sdkInitialize(getApplicationContext());
        mFacebookLoginBtn = (LoginButton) findViewById(R.id.facebookLoginBtn);
        mFacebookLoginBtn.setReadPermissions(Arrays.asList("public_profile, email"));
        callbackManager = CallbackManager.Factory.create();
        mFacebookLoginBtn.registerCallback(callbackManager, callback);
    }

    public void setFacebookToken(String facebookToken) {
        this.facebookToken = facebookToken;
    }

    private FacebookCallback<LoginResult> callback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            Log.d(TAG, "onSuccess: ");

            Log.d(TAG, "onSuccess: "+loginResult.getAccessToken());
            setFacebookToken(loginResult.getAccessToken().getToken());

            sendFacebookTokenToServer();

            // facebook logout
        }

        @Override
        public void onCancel() {
            Log.d(TAG, "onCancel: User Cancel");
        }

        @Override
        public void onError(FacebookException error) {
            Log.d(TAG, "onError: Error");
            error.printStackTrace();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void sendFacebookTokenToServer() {
        Log.d(TAG, "sendFacebookTokenToServer: " + facebookToken);
    }
}
