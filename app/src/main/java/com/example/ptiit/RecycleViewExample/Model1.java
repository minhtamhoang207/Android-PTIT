package com.example.ptiit.RecycleViewExample;

public class Model1 {

    String content;
    int image;
    String title;

    public Model1(String title, String content, int image) {
        this.title = title;
        this.content = content;
        this.image = image;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
