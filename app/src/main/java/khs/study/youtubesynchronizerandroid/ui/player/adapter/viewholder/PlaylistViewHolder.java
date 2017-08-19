package khs.study.youtubesynchronizerandroid.ui.player.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import khs.study.youtubesynchronizerandroid.R;
import khs.study.youtubesynchronizerandroid.models.player.VideoItem;

/**
 * Created by jaeyoung on 7/22/17.
 */

public class PlaylistViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "PlaylistViewHolder";
    private final ImageView mIvThumbnail;
    private final TextView mTvTitle;
    private final ImageView mIvThreedot;

    private VideoItem mItem;

    public PlaylistViewHolder(View view, Consumer<VideoItem> itemClickedAction, Action threedotClickedAction) {
        super(view);

        view.setOnLongClickListener(
                (v) -> {
                    Query query1 = FirebaseDatabase.getInstance().getReference("item")
                            .orderByChild("title");
                    Query querySeach = query1.equalTo("title2videotitle");
                    querySeach.addListenerForSingleValueEvent(
                            new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    Log.d(TAG, "onDataChange() called with: dataSnapshot = [" + dataSnapshot + "]");
                                    for (DataSnapshot item:
                                    dataSnapshot.getChildren()) {
                                        item.getRef().removeValue();
                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            }
                    );
                    return false;
                }
        );
        mIvThumbnail = (ImageView) itemView.findViewById(R.id.iv_thumbnail);
        mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        mTvTitle.setOnClickListener(
                (v) -> {
                    try {
                        itemClickedAction.accept(mItem);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );
        mIvThreedot = (ImageView) itemView.findViewById(R.id.iv_threedot);
        mIvThreedot.setOnClickListener(
                (v) -> {
                    try {
                        threedotClickedAction.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );
    }

    public void configureWith(VideoItem videoItem) {
        mItem = videoItem;
        mTvTitle.setText(videoItem.getTitle());
    }
}
