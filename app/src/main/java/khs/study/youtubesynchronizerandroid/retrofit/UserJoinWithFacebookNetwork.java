package khs.study.youtubesynchronizerandroid.retrofit;

import khs.study.youtubesynchronizerandroid.domain.ApiResponseDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by jaeyoung on 2017. 4. 15..
 */

public interface UserJoinWithFacebookNetwork {
    @GET("loginWithFacebook")
    Call<ApiResponseDto> getUserJoinWithFacebookNetwork(@Header("userType") String type, @Header("token") String token);
}
