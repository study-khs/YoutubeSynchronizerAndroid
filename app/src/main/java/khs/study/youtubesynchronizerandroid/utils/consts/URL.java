package khs.study.youtubesynchronizerandroid.utils.consts;

/**
 * Created by jaeyoung on 2017. 4. 15..
 */

public class URL {
    private static final String ourServerURL = "http://13.124.12.120:8081/";
    private static final String youtubeDataApiURL = "https://www.googleapis.com/";
    public static final String djangoTestServerURL = "http://52.79.142.130/";

    public static String getOurServerURL() {
        return ourServerURL;
    }
    public static String getYoutubeDataApiURL() {
        return youtubeDataApiURL;
    }
}
