package com.github.iamexhausted.nullsectorgame.model.sprite;

import com.github.iamexhausted.nullsectorgame.model.image_system.ImgId;

/**
 * Base class for all renderable world objects.
 * <p>
 * Stores sprite position, image identifier
 * and collision hitbox configuration.
 */
public abstract class Sprite {
    private ImgId imgId;
    protected boolean facingRight = true;
    protected double x, y;
    protected Hitbox hitbox;

    // --- Collision tuning ---
    protected double hitboxOffsetX = 0;
    protected double hitboxOffsetY = 0;
    protected double hitboxWidthScale = 1.0;
    protected double hitboxHeightScale = 1.0;

    public Sprite(ImgId imgId, double x, double y) {
        this.imgId = imgId;
        this.x = x;
        this.y = y;
        initHitbox();
    }

    private void initHitbox() {
        hitbox = new Hitbox((int) x, (int) y, imgId.getWidth(), imgId.getHeight());
    }

    public abstract void update(double deltaTime);

    public ImgId getImgId() {
        return imgId;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     * Returns dynamically calculated hitbox based on current
     * sprite position, scaling and facing direction.
     *
     * @return current collision hitbox
     */
    public Hitbox getHitbox() {

        double w = imgId.getWidth() * hitboxWidthScale;
        double h = imgId.getHeight() * hitboxHeightScale;

        double hx;

        if (facingRight) {
            hx = x + hitboxOffsetX;
        } else {
            hx = x + imgId.getWidth() - w - hitboxOffsetX;
        }

        double hy = y + hitboxOffsetY;

        return new Hitbox(hx, hy, w, h);
    }

    public void setHitboxScale(double widthScale, double heightScale) {
        this.hitboxWidthScale = widthScale;
        this.hitboxHeightScale = heightScale;
    }

    public void setHitboxOffset(double x, double y) {
        this.hitboxOffsetX = x;
        this.hitboxOffsetY = y;
    }

    public double getHitboxWidth() {
        return imgId.getWidth() * hitboxWidthScale;
    }

    public double getHitboxHeight() {
        return imgId.getHeight() * hitboxHeightScale;
    }

    public boolean isFacingRight() {
        return facingRight;
    }

    public void setFacingRight(boolean facingRight) {
        this.facingRight = facingRight;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setImgId(ImgId imgId) {
        this.imgId = imgId;
    }
}
