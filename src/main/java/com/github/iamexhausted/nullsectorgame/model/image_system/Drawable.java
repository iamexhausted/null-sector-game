package com.github.iamexhausted.nullsectorgame.model.image_system;

/**
 * Immutable render data used by the rendering system.
 * <p>
 * Drawable contains all information necessary to render
 * a sprite frame on screen.
 */
public record Drawable(
        ImgId imgId,
        double x,
        double y,
        boolean facingRight
) {}