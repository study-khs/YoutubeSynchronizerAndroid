package khs.study.youtubesynchronizerandroid.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import khs.study.youtubesynchronizerandroid.R;

/**
 * Created by jaeyoung on 2017. 6. 11..
 */

public class EmailLoginActivity extends AppCompatActivity {
    private final String TAG = "JYP" + getClass().getSimpleName();
    private Button loginBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {
        loginBtn = (Button) findViewById(R.id.emailLoginBtn);

        loginBtn.setOnClickListener( (v) -> {
            Log.d(TAG, "initView: ");
        } );
    }
}

