package khs.study.youtubesynchronizerandroid.models.login;

import lombok.Data;

/**
 * Created by jaeyoung on 2017. 6. 3..
 */

@Data
public class User {
    private String userLoginId;
    private String userNickname;
    private String userPassword;
    private String userType;
}
