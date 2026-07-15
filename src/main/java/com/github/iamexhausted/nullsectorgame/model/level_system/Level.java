package com.github.iamexhausted.nullsectorgame.model.level_system;

import com.github.iamexhausted.nullsectorgame.model.platform.Platform;

import java.util.List;

public class Level {
    private final List<Platform> platforms;

    public Level(List<Platform> platforms) {
        this.platforms = platforms;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }
}
