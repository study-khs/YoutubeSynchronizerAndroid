package khs.study.youtubesynchronizerandroid.retrofit;

import khs.study.youtubesynchronizerandroid.domain.User;
import khs.study.youtubesynchronizerandroid.domain.UserJoinWithFacebookRequestDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by jaeyoung on 2017. 4. 15..
 */

public interface UserJoinWithFacebookNetwork {
    @GET("api/user_join_with_facebook_network")
    Call<User> getUserJoinWithFacebookNetwork(@Header("type") String type, @Header("token") String token);
}
