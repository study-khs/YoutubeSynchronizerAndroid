package khs.study.youtubesynchronizerandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

import khs.study.youtubesynchronizerandroid.domain.ApiResponseDto;
import khs.study.youtubesynchronizerandroid.retrofit.DefaultClient;
import khs.study.youtubesynchronizerandroid.retrofit.UserJoinWithFacebookNetwork;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "JYP/"+getClass().getSimpleName();
    private LoginButton mFacebookLoginBtn;
    private CallbackManager callbackManager;

    private DefaultClient<UserJoinWithFacebookNetwork> mDefaultClient;
    private UserJoinWithFacebookNetwork mUserJoinWithFacebookNetwork;

    private String facebookToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // facebook init
        initFacebookLogin();

        // retrofit init
        initRetrofit();
    }

    private void initRetrofit() {
        mDefaultClient = new DefaultClient<>();
        mUserJoinWithFacebookNetwork = mDefaultClient.getClient(
                UserJoinWithFacebookNetwork.class);
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
            Log.d(TAG, "onCancel: ApiResponseDto Cancel");
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

        getUserJoinWithFacebookNetwork("FACEBOOK", facebookToken);
    }

    private void getUserJoinWithFacebookNetwork(String type, String token) {
        Call<ApiResponseDto> call = mUserJoinWithFacebookNetwork
                                .getUserJoinWithFacebookNetwork(type, token);

        call.enqueue(new Callback<ApiResponseDto>() {
            @Override
            public void onResponse(Call<ApiResponseDto> call, Response<ApiResponseDto> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: isSuccessful");

                    ApiResponseDto apiResponseDto = response.body();
                    if ("200".equals(apiResponseDto.getResultCode())) {
                        // todo save apiResponseDto
                        Log.d(TAG, "onResponse: "+apiResponseDto.getData());
                    } else {
                        Log.d(TAG, "onResponse: Unexpected Response");
                    }
                } else {
                    Log.d(TAG, "onResponse: isFailure");
                }
            }

            @Override
            public void onFailure(Call<ApiResponseDto> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
                t.printStackTrace();
            }
        });

        Log.d(TAG, "getUserJoinWithFacebookNetwork: ");
    }
}
