package khs.study.youtubesynchronizerandroid.ui.player.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import khs.study.youtubesynchronizerandroid.R;
import khs.study.youtubesynchronizerandroid.models.player.VideoItem;
import khs.study.youtubesynchronizerandroid.ui.player.adapter.viewholder.PlaylistViewHolder;

/**
 * Created by jaeyoung on 7/22/17.
 */

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistViewHolder> {
    private List<VideoItem> videoItems;

    public PlaylistAdapter() {
    }

    public PlaylistAdapter(List<VideoItem> videoItems) {
        this.videoItems = videoItems;
    }

    @Override
    public PlaylistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.)


        View deviceMenuView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.device_devicemenuadapter_cardview,
                        parent, false);

        final DeviceMenuViewHolder deviceMenuViewHolder =
                new DeviceMenuViewHolder(deviceMenuView,
                        mDeviceItemIvClickedListener,
                        mThreedotIvClickedListener);

        return deviceMenuViewHolder;
        return null;
    }

    @Override
    public void onBindViewHolder(PlaylistViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return videoItems.size();
    }
}
