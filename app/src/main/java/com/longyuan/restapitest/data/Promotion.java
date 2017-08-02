package com.longyuan.restapitest.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by loxu on 26/07/2017.
 */

public class Promotion {

    public Promotion(String id, String title) {
        this.id = id;
        this.title = title;
    }

    @SerializedName("id")
    String id;

    String image;

    @SerializedName("title")
    String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
