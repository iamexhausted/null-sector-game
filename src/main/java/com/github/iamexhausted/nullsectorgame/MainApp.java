package com.github.iamexhausted.nullsectorgame;

import com.github.iamexhausted.nullsectorgame.controller.GameTimerController;
import com.github.iamexhausted.nullsectorgame.model.Model;
import com.github.iamexhausted.nullsectorgame.view.GameView;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage){
        // --- 1. Model ---
        Model model = new Model();

        // --- 2. View ---
        GameView gameView = new GameView(model);

        // --- 3. Controllers ---
        GameTimerController timer = new GameTimerController(model, gameView);

        // --- 4. Stage ---
        stage.setTitle("Null Sector");
        stage.show();

        // --- 5. Game Loop ---
        timer.start();
    }
}
