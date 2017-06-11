package khs.study.youtubesynchronizerandroid.services.network.login;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by jaeyoung on 2017. 4. 15..
 */

public interface UserJoinWithFacebookNetwork {
    @GET("loginWithFacebook")
    Call getUserJoinWithFacebookNetwork(@Header("userType") String type, @Header("token") String token);
}
