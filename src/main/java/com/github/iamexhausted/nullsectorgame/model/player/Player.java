package com.github.iamexhausted.nullsectorgame.model.player;

import com.github.iamexhausted.nullsectorgame.model.entity.Entity;
import com.github.iamexhausted.nullsectorgame.model.image_system.ImgId;

public class Player extends Entity {
    // speed
    private double vx = 0;
    private double vy = 0;

    // input flags
    private boolean moveRight;
    private boolean moveLeft;

    public Player(ImgId imgId, double x, double y) {
        final int MAX_HEALTH = 100;
        final int DAMAGE = 15;

        super(imgId, x, y, MAX_HEALTH, DAMAGE); // hp = 100, damage = 15

        this.setHitboxScale(0.45, 1.0);
        this.setHitboxOffset(8, 0);
    }

    @Override
    public void update(double deltaTime) {}

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }
}
