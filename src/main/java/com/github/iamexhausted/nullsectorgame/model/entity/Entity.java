package com.github.iamexhausted.nullsectorgame.model.entity;

import com.github.iamexhausted.nullsectorgame.model.image_system.ImgId;
import com.github.iamexhausted.nullsectorgame.model.sprite.Sprite;

/**
 * Base abstract class for all living entities in the game.
 * <p>
 * Entity extends Sprite by adding health, damage and combat-related
 * functionality shared by the player and enemies.
 */
public abstract class Entity extends Sprite {

    protected int health;
    protected int maxHealth;
    protected int damage;

    public Entity(ImgId imgId, double x, double y, int maxHealth, int damage) {
        super(imgId, x, y);
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {return maxHealth;}

    public int getDamage() {
        return damage;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Applies damage to the entity.
     * Health value is clamped to zero.
     *
     * @param amount amount of damage to apply
     */
    public void takeDamage(int amount) {
        health -= amount;

        if (health < 0) {
            health = 0;
        }
    }

    /**
     * Restores entity health by the given amount.
     * Health cannot exceed maximum health.
     *
     * @param amount amount of health restored
     */
    public void heal(int amount) {

        health += amount;

        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    public void restoreFullHealth() {
        health = maxHealth;
    }
}