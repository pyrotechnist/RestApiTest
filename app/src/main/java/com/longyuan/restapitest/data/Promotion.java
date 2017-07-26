package com.longyuan.restapitest.data;

/**
 * Created by loxu on 26/07/2017.
 */

public class Promotion {

    public Promotion(String id, String title) {
        this.id = id;
        this.title = title;
    }

    String id;

    String image;

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
