package khs.study.youtubesynchronizerandroid.models.login;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jaeyoung on 2017. 4. 15..
 */

public class ApiResponseDto<T> implements Serializable {
    @SerializedName("data")
    private T data;
    @SerializedName("resultCode")
    private String resultCode;
    @SerializedName("resultMessage")
    private String resultMessage;

    public ApiResponseDto(T data, String resultCode, String resultMessage) {
        this.data = data;
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

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
}
