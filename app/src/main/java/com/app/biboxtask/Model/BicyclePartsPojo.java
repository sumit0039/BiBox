package com.app.biboxtask.Model;

public class BicyclePartsPojo {
    int Image;
    String name;

    public BicyclePartsPojo(int image, String name) {
        Image = image;
        this.name = name;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

