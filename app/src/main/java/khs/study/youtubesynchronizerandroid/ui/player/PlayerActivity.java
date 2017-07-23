package khs.study.youtubesynchronizerandroid.ui.player;

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

import java.util.List;

import khs.study.youtubesynchronizerandroid.R;
import khs.study.youtubesynchronizerandroid.models.player.VideoItem;
import khs.study.youtubesynchronizerandroid.models.player.dummy.DummyVideoItem;
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
