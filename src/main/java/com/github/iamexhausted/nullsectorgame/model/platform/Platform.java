package com.github.iamexhausted.nullsectorgame.model.platform;

import com.github.iamexhausted.nullsectorgame.model.image_system.ImgId;
import com.github.iamexhausted.nullsectorgame.model.sprite.Sprite;

public class Platform extends Sprite {

    public Platform(ImgId imgId, double x, double y) {
        super(imgId, x, y);
    }

    @Override
    public void update(double deltaTime) {}
}
