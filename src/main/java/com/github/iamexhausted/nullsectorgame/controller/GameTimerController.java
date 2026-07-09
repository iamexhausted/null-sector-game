package com.github.iamexhausted.nullsectorgame.controller;

import com.github.iamexhausted.nullsectorgame.model.Model;
import com.github.iamexhausted.nullsectorgame.view.GameView;
import javafx.animation.AnimationTimer;

public class GameTimerController extends AnimationTimer {
    private final Model model;
    private final GameView gameView;

    public GameTimerController(Model model, GameView gameView) {
        this.model = model;
        this.gameView = gameView;
    }


    @Override
    public void handle(long now) {
        model.update();
        gameView.render();
    }
}
