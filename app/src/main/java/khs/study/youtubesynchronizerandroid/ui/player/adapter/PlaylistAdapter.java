package khs.study.youtubesynchronizerandroid.ui.player.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import khs.study.youtubesynchronizerandroid.R;
import khs.study.youtubesynchronizerandroid.models.player.VideoItem;
import khs.study.youtubesynchronizerandroid.ui.player.adapter.viewholder.PlaylistViewHolder;

/**
 * Created by jaeyoung on 7/22/17.
 */

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistViewHolder> {
    private final Consumer<VideoItem> itemClickedAction;
    private final Action threedotClickedAction;
    private List<VideoItem> mVideoItems;

    public PlaylistAdapter(List<VideoItem> videoItems,
                           Consumer<VideoItem> itemClickedAction,
                           Action threedotClickedAction) {
        this.mVideoItems = videoItems;
        this.itemClickedAction = itemClickedAction;
        this.threedotClickedAction = threedotClickedAction;
    }

    @Override
    public PlaylistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_video,
                        parent, false);

        PlaylistViewHolder playlistViewHolder = new PlaylistViewHolder(view,
                itemClickedAction,
                threedotClickedAction);

        return playlistViewHolder;
    }

    @Override
    public void onBindViewHolder(PlaylistViewHolder holder, int position) {
        VideoItem videoItem = mVideoItems.get(position);

        holder.configureWith(videoItem);
    }

    @Override
    public int getItemCount() {
        return mVideoItems.size();
    }

    public void setItems(List<VideoItem> items) {
        this.mVideoItems = items;
        notifyDataSetChanged();
    }
}
