package khs.study.youtubesynchronizerandroid.models.login;

import lombok.Data;
import lombok.Getter;

/**
 * Created by jaeyoung on 2017. 6. 3..
 */

@Data
public class UserLoginForm {
    @Getter
    private String userType;
    private String userLoginId;
    private String userPassword;
}
