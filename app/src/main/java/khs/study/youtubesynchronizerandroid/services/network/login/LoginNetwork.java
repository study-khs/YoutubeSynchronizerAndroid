package khs.study.youtubesynchronizerandroid.services.network.login;

import khs.study.youtubesynchronizerandroid.models.BaseDto;
import khs.study.youtubesynchronizerandroid.models.login.User;
import khs.study.youtubesynchronizerandroid.models.login.UserJoinRequestDto;
import khs.study.youtubesynchronizerandroid.models.login.dto.TokenDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by jaeyoung on 2017. 6. 11..
 */

public interface LoginNetwork {
    @GET("/api/user/login")
    Call<TokenDto> getToken(
            @Header("userType") String userType,
            @Header("userLoginId") String userLoginId,
            @Header("userPassword") String userPassword);

    @POST("/api/user/join")
    Call<TokenDto> signUpUser(
            @Body UserJoinRequestDto dto);
}
