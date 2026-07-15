package com.github.iamexhausted.nullsectorgame.model.level_system;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages currently active level and player transitions between levels.
 * <p>
 * The manager is also responsible for respawning and checkpoint handling.
 */
public class LevelManager {

    private final Map<String, Level> levels = new HashMap<>();

    private Level currentLevel;

    private String currentLevelId;

    public Level getCurrentLevel() {
        return currentLevel;
    }

    public String getCurrentLevelId() {
        return currentLevelId;
    }

    public void addLevel(String id, Level level) {
        levels.put(id, level);
    }

    /**
     * Loads level and moves player to spawn position.
     *
     * @param id level identifier
     */
    public void loadLevel(String id) {
        currentLevel = levels.get(id);
        currentLevelId = id;
    }
}