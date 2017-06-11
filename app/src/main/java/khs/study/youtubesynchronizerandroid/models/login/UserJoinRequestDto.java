package khs.study.youtubesynchronizerandroid.models.login;

import lombok.Data;

/**
 * Created by jaeyoung on 2017. 6. 11..
 */
@Data
public class UserJoinRequestDto {
    private String userType;
    private String userLoginId;
    private String userNickname;
    private String userPassword;

    public UserJoinRequestDto(String userType, String userLoginId, String userNickname, String userPassword) {
        this.userType = userType;
        this.userLoginId = userLoginId;
        this.userNickname = userNickname;
        this.userPassword = userPassword;
    }
}
