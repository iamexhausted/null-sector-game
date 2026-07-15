package com.github.iamexhausted.nullsectorgame;

import com.github.iamexhausted.nullsectorgame.controller.GameKbdController;
import com.github.iamexhausted.nullsectorgame.controller.GameTimerController;
import com.github.iamexhausted.nullsectorgame.model.Model;
import com.github.iamexhausted.nullsectorgame.model.input.InputState;
import com.github.iamexhausted.nullsectorgame.view.GameView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage){
        // --- 1. Model + Input ---
        Model model = new Model();
        InputState input = new InputState();

        // --- 2. Views ---
        GameView gameView = new GameView(model);
        Scene gameScene = gameView.getScene();

        // --- 3. Controllers ---
        GameKbdController kbd = new GameKbdController(input);
        GameTimerController timer = new GameTimerController(model, input, gameView);

        // --- 4. Input (Game scene + Inventory scene) ---
        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, kbd);
        gameScene.addEventHandler(KeyEvent.KEY_RELEASED, kbd);

        // --- 5. Stage ---
        stage.setTitle("Null Sector");
        stage.setScene(gameView.getScene());
        stage.show();

        // --- 6. Game Loop ---
        timer.start();
    }
}
