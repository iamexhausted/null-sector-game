package com.github.iamexhausted.nullsectorgame.model.player;

import com.github.iamexhausted.nullsectorgame.model.entity.Entity;
import com.github.iamexhausted.nullsectorgame.model.image_system.ImgId;

public class Player extends Entity {
    // speed
    private double vx = 0;
    private double vy = 0;

    // constants
    private final double ACCELERATION = 0.5;
    private final double FRICTION = 0.9;

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

    /**
     * Updates player state for current frame.
     * <p>
     * Handles horizontal movement.
     *
     * @param deltaTime frame delta time
     */
    @Override
    public void update(double deltaTime) {
        applyInput();

        applyPhysics();
    }

    /**
     * Applies player input to movement system.
     * <p>
     * Handles movement acceleration.
     */
    private void applyInput() {

        if (moveLeft) {
            vx -= ACCELERATION;
        }

        if (moveRight) {
            vx += ACCELERATION;
        }
    }

    /**
     * Applies ground friction.
     * <p>
     * Prevents infinite sliding movement.
     */
    private void applyFriction() {
        vx *= FRICTION;

        // to avoid constant gliding
        if (Math.abs(vx) < 0.01) {
            vx = 0;
        }
    }

    /**
     * Applies movement physics.
     * <p>
     * Handles:
     * - friction
     * - movement update
     */
    private void applyPhysics() {
        // friction
        applyFriction();

        // movement
        x += vx;
        y += vy;
    }

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }
}
