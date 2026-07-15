package com.github.iamexhausted.nullsectorgame.model;

import com.github.iamexhausted.nullsectorgame.model.image_system.Drawable;
import com.github.iamexhausted.nullsectorgame.model.image_system.ImgId;
import com.github.iamexhausted.nullsectorgame.model.input.InputState;
import com.github.iamexhausted.nullsectorgame.model.level_system.Level;
import com.github.iamexhausted.nullsectorgame.model.level_system.LevelLoader;
import com.github.iamexhausted.nullsectorgame.model.level_system.LevelManager;
import com.github.iamexhausted.nullsectorgame.model.platform.Platform;
import com.github.iamexhausted.nullsectorgame.model.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Model {
    // --- LEVEL MANAGER ---
    private final LevelManager levelManager;

    public Model() {
        Player player = new Player(ImgId.PLAYER_IDLE_1, 40, 100);

        levelManager = new LevelManager(player);

        // Load all game levels.
        LevelLoader loader = new LevelLoader();

        levelManager.addLevel("level1", loader.load("/levels/level1.json"));

        loadGame();
    }

    /**
     * Main game update loop executed every frame.
     *
     * @param deltaTime frame delta time
     * @param input current input state
     */
    public void update(double deltaTime, InputState input) {

        Player player = levelManager.getPlayer();

        // Apply player movement input.
        player.setMoveLeft(input.moveLeft);
        player.setMoveRight(input.moveRight);

        player.update(deltaTime);
    }

    public void loadGame() {
        levelManager.loadLevel("level1");
    }


    public Drawable[] getDrawables() {
        List<Drawable> drawables = new ArrayList<>();

        Player player = levelManager.getPlayer();
        Level level = levelManager.getCurrentLevel();

        // 1. platforms
        for (Platform p : level.getPlatforms()) {
            drawables.add(new Drawable(p.getImgId(), p.getX(), p.getY(), true));
        }

        // 2. player
        drawables.add(new Drawable(player.getImgId(), player.getX(), player.getY(), player.isFacingRight()));

        return drawables.toArray(new Drawable[0]);
    }
}
