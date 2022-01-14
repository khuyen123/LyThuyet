package com.example.lythuyet;

public class intro_screen_item {
    String title,description;
    int introImg;

    public intro_screen_item(String title, String description, int introImg) {
        this.title = title;
        this.description = description;
        this.introImg = introImg;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIntroImg(int introImg) {
        this.introImg = introImg;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getIntroImg() {
        return introImg;
    }
}
