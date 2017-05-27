package khs.study.youtubesynchronizerandroid.model.login.djangotest;

import khs.study.youtubesynchronizerandroid.utils.consts.URL;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jaeyoung on 2017. 4. 15..
 */

public class DjangotestDefaultClient<T> {
    private T service;
    private String baseUrl = URL.djangoTestServerURL;

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
