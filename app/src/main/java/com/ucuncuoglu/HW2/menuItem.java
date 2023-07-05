package com.ucuncuoglu.HW2;

public class menuItem {
    private String title;
    private int imgId;

    public menuItem(String title, int imgId) {
        this.title = title;
        this.imgId=imgId;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
