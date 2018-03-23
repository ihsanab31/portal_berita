package com.sundevs.ihsan.newsapps.api;

import com.sundevs.ihsan.newsapps.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

public interface EndPoint {

    @GET("/v2/top-headlines")
    Call<NewsResponse> getListNews(
            @Query("country") String country,
            @Query("category") String category,
            @Query("apiKey") String apiKey);

}
