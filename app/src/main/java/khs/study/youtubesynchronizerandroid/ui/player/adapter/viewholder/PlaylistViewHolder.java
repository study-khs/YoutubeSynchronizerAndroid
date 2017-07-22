package khs.study.youtubesynchronizerandroid.ui.player.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import io.reactivex.functions.Action;
import khs.study.youtubesynchronizerandroid.R;
import khs.study.youtubesynchronizerandroid.models.player.VideoItem;

/**
 * Created by jaeyoung on 7/22/17.
 */

public class PlaylistViewHolder extends RecyclerView.ViewHolder {
    private final ImageView mIvThumbnail;
    private final TextView mTvTitle;
    private final ImageView mIvThreedot;

    public PlaylistViewHolder(View view, Action itemClickedAction, Action threedotClickedAction) {
        super(view);

        mIvThumbnail = (ImageView) itemView.findViewById(R.id.iv_thumbnail);
        mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        mTvTitle.setOnClickListener(
                (v) -> {
                    try {
                        itemClickedAction.run();
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
        mTvTitle.setText(videoItem.getTitle());
    }
}
