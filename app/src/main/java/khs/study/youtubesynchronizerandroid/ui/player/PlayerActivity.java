package khs.study.youtubesynchronizerandroid.ui.player;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import khs.study.youtubesynchronizerandroid.R;
import khs.study.youtubesynchronizerandroid.models.player.dummy.DummyVideoItem;
import khs.study.youtubesynchronizerandroid.ui.player.adapter.PlaylistAdapter;

public class PlayerActivity extends AppCompatActivity {
    private static final String TAG = "PlayerActivity";

    private RecyclerView mRecyclerViewPlaylist;
    private RecyclerView mRecyclerViewSearchresults;
    private PlaylistAdapter mAdapterPlaylist;
    private PlaylistAdapter mAdapterSearchresults;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        attachUI();
    }

    private void attachUI() {
        Log.d(TAG, "attachUI: ");
        mRecyclerViewSearchresults = (RecyclerView) findViewById(R.id.recyclerview_searchresults);
        mRecyclerViewPlaylist = (RecyclerView) findViewById(R.id.recyclerview_playlist);
        initRecyclerViews();
    }

    private void initRecyclerViews() {
        Log.d(TAG, "initRecyclerViews: ");

        mAdapterSearchresults = new PlaylistAdapter(
                DummyVideoItem.getDummyVideoItems(),
                () -> {
                    addToPlaylist();
                    play();
                },
                this::removeFromPlaylist
        );
        mAdapterPlaylist = new PlaylistAdapter(
                DummyVideoItem.getDummyVideoItems(),
                () -> {
                    addToPlaylist();
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

    private void addToPlaylist() {
        Log.d(TAG, "addToPlaylist: ");
    }
}
