package khs.study.youtubesynchronizerandroid.services.network.player;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jaeyoung on 2017. 4. 22..
 */

public interface YoutubeDataApiNetwork {
    @GET("youtube/v3/search?part=id,snippet&type=video")
    Call<HashMap> getSearchResults(@Query("q") String q,
                                   @Query("key") String key);
}
