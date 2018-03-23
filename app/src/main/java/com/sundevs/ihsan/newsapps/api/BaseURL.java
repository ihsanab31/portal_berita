package com.sundevs.ihsan.newsapps.api;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

public class BaseURL {

    public static final String BASE_URL_API = "https://newsapi.org/";

    public static EndPoint getAPIService(){
        return APIClient.getClient(BASE_URL_API).create(EndPoint.class);
    }

}
