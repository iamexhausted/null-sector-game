package com.github.iamexhausted.nullsectorgame.model.image_system;

/**
 * Enumeration of all image resources used in the game.
 * <p>
 * Each enum value stores relative path to the texture
 * and runtime-loaded dimensions of the image.
 */
public enum ImgId {
    // --- PLAYER ---
    PLAYER_IDLE_1("hero/hero_idle/hero_idle1.png"),

    // --- OTHER ---
    PLATFORM("platform/platform.png");

    private final String imgName;
    private double height, width;

    ImgId(String imgName) {
        this.imgName = imgName;
    }

    public String getImgName() { return imgName;}

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
