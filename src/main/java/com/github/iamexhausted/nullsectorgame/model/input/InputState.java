package com.github.iamexhausted.nullsectorgame.model.input;

/**
 * Stores current player input state for a single frame.
 * <p>
 * The class separates one-time button presses from
 * continuously held inputs.
 */
public class InputState {
    public boolean moveLeft;
    public boolean moveRight;

    /**
     * Clears gameplay-related input flags after processing.
     * <p>
     * This prevents repeated execution of one-frame actions.
     */
    public void resetGameplayInput() {
        moveLeft = false;
        moveRight = false;
    }

}
