package khs.study.youtubesynchronizerandroid.ui.player;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import khs.study.youtubesynchronizerandroid.R;
import khs.study.youtubesynchronizerandroid.models.player.VideoItem;
import khs.study.youtubesynchronizerandroid.models.player.dummy.DummyVideoItem;
import khs.study.youtubesynchronizerandroid.ui.EmailLoginActivity;
import khs.study.youtubesynchronizerandroid.ui.player.adapter.PlaylistAdapter;
import khs.study.youtubesynchronizerandroid.ui.player.presenter.PlayerPresenter;
import khs.study.youtubesynchronizerandroid.ui.player.view.PlayerView;

public class PlayerActivity extends AppCompatActivity implements PlayerView {
    private static final String TAG = "PlayerActivity";

    private RecyclerView mRecyclerViewPlaylist;
    private RecyclerView mRecyclerViewSearchresults;
    private PlaylistAdapter mAdapterPlaylist;
    private PlaylistAdapter mAdapterSearchresults;
    private Button mBtnSearch;
    private PlayerPresenter mPresenter;
    private EditText mEtSearchKeyword;
    private ProgressBar mProgressbarSearch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        Log.d(TAG, "onCreate: ");
        initPresenter();
        attachUI();

        FirebaseDatabase.getInstance().getReference("item")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Log.d(TAG, "onDataChange: ");
                        ArrayList<VideoItem> result = new ArrayList<VideoItem>();

                        for (DataSnapshot item:
                        dataSnapshot.getChildren()) {
                            result.add(item.getValue(VideoItem.class));
                        }

                        dataLoadingFinished(result);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
    }

    private void dataLoadingFinished(ArrayList<VideoItem> result) {
        gotoLoginActivityWithData(result);
    }

    private void gotoLoginActivityWithData(ArrayList<VideoItem> result) {
        Intent intent = new Intent(this, EmailLoginActivity.class);
        intent.putExtra("VIDEOITEMS", result);
        startActivity(intent);
    }

    private void initPresenter() {
        Log.d(TAG, "initPresenter: ");
        mPresenter = new PlayerPresenter(this);
    }

    private void attachUI() {
        Log.d(TAG, "attachUI: ");
        mRecyclerViewSearchresults = (RecyclerView) findViewById(R.id.recyclerview_searchresults);
        mRecyclerViewPlaylist = (RecyclerView) findViewById(R.id.recyclerview_playlist);
        mBtnSearch = (Button) findViewById(R.id.btn_search);
        mBtnSearch.setOnClickListener(
                v -> mPresenter.searchClicked()
        );
        mEtSearchKeyword = (EditText) findViewById(R.id.et_searchkeyword);
        mProgressbarSearch = (ProgressBar) findViewById(R.id.progressbar_search);
        mProgressbarSearch.setVisibility(View.GONE);

        initRecyclerViews();
    }

    private void initRecyclerViews() {
        Log.d(TAG, "initRecyclerViews: ");

        mAdapterSearchresults = new PlaylistAdapter(
                DummyVideoItem.getDummyVideoItems(),
                (item) -> {
                    addToPlaylist(item);
                    play();
                    Log.d(TAG, "initRecyclerViews: " + item.toString());
                },
                this::removeFromPlaylist
        );
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("item");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d(TAG, "onDataChange: ");
                List<VideoItem> data = new ArrayList<>();
                for (DataSnapshot item:
                     dataSnapshot.getChildren()) {
                    VideoItem value = item.getValue(VideoItem.class);
                    data.add(value);
                }
                mAdapterPlaylist.setItems(data);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, "onCancelled: ");
            }
        });

        mAdapterPlaylist = new PlaylistAdapter(
                DummyVideoItem.getDummyVideoItems(),
                (item) -> {
                    addToPlaylist(item);
                    play();
                },
                this::removeFromPlaylist
        );

        mRecyclerViewSearchresults.setAdapter(mAdapterSearchresults);
        mRecyclerViewPlaylist.setAdapter(mAdapterPlaylist);
        mRecyclerViewSearchresults.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerViewPlaylist.setLayoutManager(new LinearLayoutManager(this));
    }

    private void removeFromPlaylist() {
        Log.d(TAG, "removeFromPlaylist: ");
    }

    private void play() {
        Log.d(TAG, "play: ");
    }

    private void addToPlaylist(VideoItem item) {
        Log.d(TAG, "addToPlaylist: ");
        FirebaseDatabase.getInstance().getReference().child("item").push().setValue(item);
    }

    @Override
    public String getSearchKeyword() {
        Editable editable = mEtSearchKeyword.getText();
        return editable.toString();
    }

    @Override
    public void clearSearchKeyword() {
        mEtSearchKeyword.setText("");
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setSearchResults(List<VideoItem> videoItems) {
        mAdapterSearchresults.setItems(videoItems);
    }

    @Override
    public void setProgress(boolean b) {
        if (b) {
            mProgressbarSearch.setVisibility(View.VISIBLE);
        } else {
            mProgressbarSearch.setVisibility(View.GONE);
        }
    }
}
