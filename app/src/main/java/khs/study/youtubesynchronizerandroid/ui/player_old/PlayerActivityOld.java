//package khs.study.youtubesynchronizerandroid.ui.player_old;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//
//import com.google.android.youtube.player.YouTubePlayer;
//import com.google.android.youtube.player.YouTubePlayerView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import khs.study.youtubesynchronizerandroid.R;
//import khs.study.youtubesynchronizerandroid.models.player.YoutubeSearchResult;
//import khs.study.youtubesynchronizerandroid.services.db.StoreOnFirebase;
//import khs.study.youtubesynchronizerandroid.services.YoutubeSearch;
//import khs.study.youtubesynchronizerandroid.ui.player.adapter.PlaylistAdapter;
//import khs.study.youtubesynchronizerandroid.utils.youtube.DeveloperKey;
//import khs.study.youtubesynchronizerandroid.utils.youtube.YouTubeFailureRecoveryActivity;
//
///**
// * Created by jaeyoung on 2017. 4. 22..
// */
//
//public class PlayerActivityOld extends YouTubeFailureRecoveryActivity {
//    private final String TAG = "JYP"+getClass().getSimpleName();
//
//    private List<YoutubeSearchResult> mSearchResults;
//    private List<String> mPlaylist = new ArrayList<>();
//    private String videoId;
//    private YouTubePlayer mPlayer;
//    private RecyclerView mRecyclerViewPlaylist;
//    private RecyclerView mRecyclerViewSearchresults;
//    private PlaylistAdapter mAdapterPlaylist;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_player);
//
//        YoutubeSearch.search("성시경",
//                results -> {
//                    Log.d(TAG, "onCreate: " + results);
//                    mSearchResults = results;
//
//                    addVideoToPlaylist(mSearchResults.get(0).getVideoId());
//                }
//        );
//        StoreOnFirebase.storeSearchHistory("성시굥");
//        StoreOnFirebase.storeAppTurnedOnAt();
//
////        YouTubePlayerView youTubeView = (YouTubePlayerView) findViewById(R.id.youtubeview_nowplaying);
////        youTubeView.initialize(DeveloperKey.DEVELOPER_KEY, this);
//
//
//        attachUI();
//    }
//
//    private void attachUI() {
//        mRecyclerViewSearchresults = (RecyclerView) findViewById(R.id.recyclerview_searchresults);
//        mRecyclerViewPlaylist = (RecyclerView) findViewById(R.id.recyclerview_playlist);
//        initRecyclerViews();
//    }
//
//    private void initRecyclerViews() {
//        mAdapterPlaylist = new PlaylistAdapter(
//                new ArrayList<>()
//        );
//    }
//
//    public void addVideoToPlaylist(String id) {
//        Log.d(TAG, "addVideoToPlaylist: id="+id);
//        mPlaylist.add(id);
//        if (id != null && !id.equals(this.videoId)) {
//            this.videoId = id;
//            if (mPlayer != null) {
//                mPlayer.cueVideo(id);
//            }
//        }
//    }
//
//    @Override
//    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player,
//                                        boolean wasRestored) {
//        if (!wasRestored) {
//            mPlayer = player;
//            mPlayer.cueVideo("wKJ9KzGQq0w");
//        }
//    }
//
////    @Override
////    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
////        return (YouTubePlayerView) findViewById(R.id.youtubeview_nowplaying);
////    }
//}
