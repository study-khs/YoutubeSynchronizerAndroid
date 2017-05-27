package khs.study.youtubesynchronizerandroid.model.login.djangotest;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by jaeyoung on 2017. 4. 15..
 */

public interface DjangoTestNetwork {
    @POST("api/social_sign_up_or_in/")
    Call<User> postUserJoinWithFacebookNetwork(@Body SocialToken socialToken);

    @POST("api/social_sign_up_or_in/")
    Call<List<HashMap>> postUserJoinWithFacebookNetworkToHashmap(@Body SocialToken socialToken);
}
