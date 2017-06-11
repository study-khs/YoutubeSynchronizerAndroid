package khs.study.youtubesynchronizerandroid.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import khs.study.youtubesynchronizerandroid.R;
import khs.study.youtubesynchronizerandroid.models.login.UserJoinRequestDto;
import khs.study.youtubesynchronizerandroid.models.login.dto.TokenDto;
import khs.study.youtubesynchronizerandroid.services.network.login.LoginNetwork;
import khs.study.youtubesynchronizerandroid.utils.retrofit.DefaultClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jaeyoung on 2017. 6. 11..
 */

public class EmailLoginActivity extends AppCompatActivity {
    private final String TAG = "JYP" + getClass().getSimpleName();
    private Button loginBtn, signUpBtn;
    private LoginNetwork mNetwork;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initNetwork();
        initView();
    }

    private void initNetwork() {
        Log.d(TAG, "initNetwork: ");
        mNetwork = (new DefaultClient<LoginNetwork>()).getClient(LoginNetwork.class);
    }

    private void initView() {
        loginBtn = (Button) findViewById(R.id.emailLoginBtn);

        loginBtn.setOnClickListener( (v) -> {
            String id = "hi";
            String pw = "baby";
            String nick = "jsbabo";
            Call<TokenDto> call = mNetwork.getToken("STANDARD", id, pw);
            call.enqueue(new Callback<TokenDto>() {
                @Override
                public void onResponse(Call<TokenDto> call, Response<TokenDto> response) {
                    if(response.isSuccessful()) {
                        TokenDto result = response.body();
                        Log.d(TAG, "onResponse: " + result.toString());
                    } else {
                        Log.d(TAG, "onResponse: code="+response.code());
                    }
                }

                @Override
                public void onFailure(Call<TokenDto> call, Throwable t) {
                    Log.d(TAG, "onFailure: "+t.toString());
                }
            });
            Log.d(TAG, "initView: ");
        } );

        signUpBtn = (Button) findViewById(R.id.emailSignUpBtn);
        signUpBtn.setOnClickListener( (v) -> {
            String id = "hi";
            String pw = "baby";
            String nick = "jsbabo";

            UserJoinRequestDto dto =
                    new UserJoinRequestDto("STANDARD", id, nick, pw);
            Call<TokenDto> call = mNetwork.signUpUser(dto);
            call.enqueue(new Callback<TokenDto>() {
                @Override
                public void onResponse(Call<TokenDto> call, Response<TokenDto> response) {
                    if(response.isSuccessful()) {
                        TokenDto result = response.body();
                        Log.d(TAG, "onResponse: " + result);
                    } else {
                        Log.d(TAG, "onResponse: code="+response.code());
                    }
                }

                @Override
                public void onFailure(Call<TokenDto> call, Throwable t) {
                    Log.d(TAG, "onFailure: "+t.toString());
                }
            });
            Log.d(TAG, "initView: ");
        });
    }
}

