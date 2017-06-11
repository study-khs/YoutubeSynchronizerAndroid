package khs.study.youtubesynchronizerandroid.models;

import lombok.Data;

/**
 * Created by jaeyoung on 2017. 6. 11..
 */
public class BaseDto<T> {
    private T data;
    private String resultCode;
    private String resultMessage;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    @Override
    public String toString() {
        return "BaseDto{" +
                "data=" + data +
                ", resultCode='" + resultCode + '\'' +
                ", resultMessage='" + resultMessage + '\'' +
                '}';
    }
}
