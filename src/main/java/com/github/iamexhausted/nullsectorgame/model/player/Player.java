package com.github.iamexhausted.nullsectorgame.model.player;

import com.github.iamexhausted.nullsectorgame.model.entity.Entity;
import com.github.iamexhausted.nullsectorgame.model.image_system.ImgId;

public class Player extends Entity {
    // speed
    private double vx = 0;
    private double vy = 0;

    // constants
    private final double GRAVITY =  0.1;
    private final double MAX_SPEED = 5;
    private final double ACCELERATION = 0.5;
    private final double FRICTION = 0.9;

    // input flags
    private boolean moveRight;
    private boolean moveLeft;

    // fall multiplier
    private final double FALL_MULTIPLIER = 2;

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

        updateFacingDirection();
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
     * Limits horizontal velocity
     * to maximum movement speed.
     */
    private void clampVelocity() {
        if (vx > MAX_SPEED) vx = MAX_SPEED;
        if (vx < -MAX_SPEED) vx = -MAX_SPEED;
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
     * - gravity
     * - fall multiplier
     * - friction
     * - movement update
     */
    private void applyPhysics() {
        // gravity
        vy += GRAVITY;

        // --- FALL MULTIPLIER ---
        if (vy > 0) {
            vy += GRAVITY * (FALL_MULTIPLIER - 1);
        }

        // limiting speed
        clampVelocity();

        // friction
        applyFriction();

        // movement
        x += vx;
        y += vy;
    }

    /**
     * Updates player facing direction
     * based on horizontal movement.
     */
    private void updateFacingDirection() {

        if (vx > 0.1) {
            facingRight = true;
        }
        else if (vx < -0.1) {
            facingRight = false;
        }
    }

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }
}
