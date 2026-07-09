package com.github.iamexhausted.nullsectorgame.model;

import com.github.iamexhausted.nullsectorgame.model.image_system.Drawable;

import java.util.ArrayList;
import java.util.List;

public class Model {
    public void update() {}

    public Drawable[] getDrawables() {
        List<Drawable> drawables = new ArrayList<>();

        return drawables.toArray(new Drawable[0]);
    }
}
