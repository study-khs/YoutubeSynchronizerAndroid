package khs.study.youtubesynchronizerandroid.retrofit;

import khs.study.youtubesynchronizerandroid.common.URL;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jaeyoung on 2017. 4. 22..
 */

public class YoutubeDataApiClient<T> {
    private T service;
    private String baseUrl = URL.getYoutubeDataApiURL();

    public T getClient(Class<? extends T> type) {
        if (service == null) {
            Retrofit client = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            service = client.create(type);
        }
        return service;
    }
}
