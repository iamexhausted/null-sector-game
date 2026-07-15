package com.github.iamexhausted.nullsectorgame.model.level_system;

import com.github.iamexhausted.nullsectorgame.model.dto.LevelData;
import com.github.iamexhausted.nullsectorgame.model.image_system.ImgId;
import com.github.iamexhausted.nullsectorgame.model.platform.Platform;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Loads game levels from JSON resources.
 * <p>
 * The loader reconstructs platforms, enemies and interaction objects
 * from serialized level data while applying persistent save state.
 * Dead enemies and removed objects are skipped according to save data.
 * <p>
 * Checkpoint triggers are automatically registered in the checkpoint registry.
 */
public class LevelLoader {

    private final Gson gson = new Gson();

    /**
     * Loads level data from resource path.
     * <p>
     * Reads JSON level description file,
     * deserializes it into DTO objects
     * and constructs full game level.
     *
     * @param path path to level JSON resource
     * @return constructed level instance
     */
    public Level load(String path) {

        InputStream is = getClass().getResourceAsStream(path);

        if (is == null) {
            throw new RuntimeException("Level not found: " + path);
        }

        LevelData data = gson.fromJson(new InputStreamReader(is), LevelData.class);

        return buildLevel(data);
    }

    /**
     * Builds game level from deserialized DTO data.
     * <p>
     * Creates platforms.
     *
     * @param levelData deserialized level DTO
     * @return fully initialized level
     */
    private Level buildLevel(LevelData levelData) {
        List<Platform> platforms = new ArrayList<>(
                levelData.platforms.stream()
                        .map(p -> new Platform(ImgId.PLATFORM, p.x, p.y))
                        .toList()
        );

        return new Level(platforms);
    }
}
