package com.example.ptiit.recycle_view_example;

public class Model1 {

    String content;
    int image;
    String title;
    String subTitle;

    public Model1(String content, String title, int image, String subTitle) {
        this.content = content;
        this.image = image;
        this.title = title;
        this.subTitle = subTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
