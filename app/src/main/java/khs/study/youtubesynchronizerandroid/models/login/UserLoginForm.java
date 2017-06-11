package khs.study.youtubesynchronizerandroid.models.login;

import lombok.Data;

/**
 * Created by jaeyoung on 2017. 6. 3..
 */

@Data
public class UserLoginForm {
    private String userType;
    private String userLoginId;
    private String userPassword;
}
