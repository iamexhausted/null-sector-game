package com.github.iamexhausted.nullsectorgame.model;

import com.github.iamexhausted.nullsectorgame.model.image_system.Drawable;
import com.github.iamexhausted.nullsectorgame.model.level_system.Level;
import com.github.iamexhausted.nullsectorgame.model.level_system.LevelLoader;
import com.github.iamexhausted.nullsectorgame.model.level_system.LevelManager;
import com.github.iamexhausted.nullsectorgame.model.platform.Platform;

import java.util.ArrayList;
import java.util.List;

public class Model {
    // --- LEVEL MANAGER ---
    private final LevelManager levelManager;

    public Model() {
        this.levelManager = new LevelManager();

        // Load all game levels.
        LevelLoader loader = new LevelLoader();

        levelManager.addLevel("level1", loader.load("/levels/level1.json"));

        loadGame();
    }

    public void update() {}

    public void loadGame() {
        levelManager.loadLevel("level1");
    }


    public Drawable[] getDrawables() {
        List<Drawable> drawables = new ArrayList<>();

        Level level = levelManager.getCurrentLevel();

        // 1. platforms
        for (Platform p : level.getPlatforms()) {
            drawables.add(new Drawable(p.getImgId(), p.getX(), p.getY(), true));
        }

        return drawables.toArray(new Drawable[0]);
    }
}
