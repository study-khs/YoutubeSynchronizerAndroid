package khs.study.youtubesynchronizerandroid.models.login.dto;

import khs.study.youtubesynchronizerandroid.models.BaseDto;
import khs.study.youtubesynchronizerandroid.models.login.Token;
import lombok.Data;

/**
 * Created by jaeyoung on 2017. 6. 11..
 */

@Data
public class TokenDto extends BaseDto<Token> {
    @Override
    public String toString() {
        return "TokenDto{" +
                super.toString() + '\'' +
                '}';
    }
}
