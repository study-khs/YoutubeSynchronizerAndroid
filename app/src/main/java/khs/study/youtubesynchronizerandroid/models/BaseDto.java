package khs.study.youtubesynchronizerandroid.models;

import lombok.Data;

/**
 * Created by jaeyoung on 2017. 6. 11..
 */
@Data
public class BaseDto<T> {
    private T data;
    private String resultCode;
    private String resultMessage;
}
