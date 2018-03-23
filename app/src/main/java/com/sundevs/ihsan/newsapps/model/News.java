package com.sundevs.ihsan.newsapps.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

public class News {

    @SerializedName("urlToImage")
    String imgNews;
    @SerializedName("title")
    String titleNews;
    @SerializedName("publishedAt")
    String dateNews;
    @SerializedName("author")
    String authorNews;
    @SerializedName("description")
    String contentNews;
    @SerializedName("url")
    String sourceNews;

    public News(String imgNews, String titleNews, String dateNews, String authorNews, String contentNews, String sourceNews) {
        this.imgNews = imgNews;
        this.titleNews = titleNews;
        this.dateNews = dateNews;
        this.authorNews = authorNews;
        this.contentNews = contentNews;
        this.sourceNews = sourceNews;
    }

    public String getImgNews() {
        return imgNews;
    }

    public String getTitleNews() {
        return titleNews;
    }

    public String getDateNews() {
        return dateNews;
    }

    public String getAuthorNews() {
        return authorNews;
    }

    public String getContentNews() {
        return contentNews;
    }

    public String getSourceNews() {
        return sourceNews;
    }
}
