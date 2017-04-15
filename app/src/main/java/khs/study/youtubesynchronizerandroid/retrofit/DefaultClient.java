package khs.study.youtubesynchronizerandroid.retrofit;

import java.io.IOException;

import khs.study.youtubesynchronizerandroid.common.URL;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jaeyoung on 2017. 4. 15..
 */

public class DefaultClient<T> {
    private T service;
    private String baseUrl = URL.getURL();

    public T getClient(Class<? extends T> type) {
        if (service == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();

                    Request request = original.newBuilder()
                            .method(original.method(), original.body())
                            .build();

                    return chain.proceed(request);
                }
            }).build();

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            service = client.create(type);
        }
        return service;
    }
}
