package com.github.iamexhausted.nullsectorgame.controller;

import com.github.iamexhausted.nullsectorgame.model.Model;
import com.github.iamexhausted.nullsectorgame.model.input.InputState;
import com.github.iamexhausted.nullsectorgame.view.GameView;
import javafx.animation.AnimationTimer;

public class GameTimerController extends AnimationTimer {
    private final Model model;
    private final InputState input;
    private final GameView gameView;

    private long prevTime = 0;

    public GameTimerController(Model model, InputState input, GameView gameView) {
        this.model = model;
        this.input = input;
        this.gameView = gameView;
    }


    @Override
    public void handle(long now) {
        if (prevTime == 0) {
            prevTime = now;
            return;
        }

        double deltaTime = (now - prevTime) / 1_000_000_000.0;
        prevTime = now;

        deltaTime = Math.min(deltaTime, 0.05);

        model.update(deltaTime, input);
        gameView.render();
    }
}
