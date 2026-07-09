package com.github.iamexhausted.nullsectorgame.view;

import com.github.iamexhausted.nullsectorgame.model.Model;
import com.github.iamexhausted.nullsectorgame.model.image_system.Drawable;
import com.github.iamexhausted.nullsectorgame.model.image_system.ImgId;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

import java.util.HashMap;
import java.util.Map;

public class GameView {

    private final double WIDTH = 1000;
    private final double HEIGHT = 800;

    private final Model model;

    private final StackPane root;
    private final Scene scene;
    private final Canvas canvas;
    private final GraphicsContext gc;

    private final Map<ImgId, Image> images = new HashMap<>();

    /**
     * Creates and initializes main game view.
     *
     * @param model game model
     */
    public GameView(Model model) {
        this.model = model;

        this.canvas = new Canvas(WIDTH, HEIGHT);
        this.gc = canvas.getGraphicsContext2D();

        this.root = new StackPane(
                canvas
        );

        this.scene = new Scene(root, WIDTH, HEIGHT);

        loadImages();
    }

    /**
     * Renders complete game frame.
    */
    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // --- WORLD ---
        for (Drawable d : model.getDrawables()) {
            Image img = images.get(d.imgId());

            gc.drawImage(
                    img,
                    0,
                    0
            );
        }
    }

    /**
     * Loads all game images into cache.
     * <p>
     * Also stores image dimensions inside ImgId.
     *
     * @throws RuntimeException if image is missing
     */
    private void loadImages() {
        for (ImgId id : ImgId.values()) {

            String path = "/images/" + id.getImgName();

            var url = getClass().getResource(path);

            if (url == null) {
                throw new RuntimeException("Image not found: " + path);
            }

            Image img = new Image(url.toExternalForm());

            id.setWidth(img.getWidth());
            id.setHeight(img.getHeight());

            images.put(id, img);
        }
    }

    public Scene getScene() {
        return scene;
    }
}
