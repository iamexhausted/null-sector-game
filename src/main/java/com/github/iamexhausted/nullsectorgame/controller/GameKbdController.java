package com.github.iamexhausted.nullsectorgame.controller;

import com.github.iamexhausted.nullsectorgame.model.input.InputState;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class GameKbdController implements EventHandler<KeyEvent> {
    private final InputState input;

    public GameKbdController(InputState input) {
        this.input = input;
    }

    @Override
    public void handle(KeyEvent e) {

        boolean pressed = e.getEventType() == KeyEvent.KEY_PRESSED;

        switch (e.getCode()) {

            case A, LEFT -> input.moveLeft = pressed;

            case D, RIGHT -> input.moveRight = pressed;
        }
    }
}

