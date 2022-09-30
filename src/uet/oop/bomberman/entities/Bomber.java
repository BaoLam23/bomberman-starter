package uet.oop.bomberman.entities;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import static uet.oop.bomberman.graphics.Sprite.SCALED_SIZE;

public class Bomber extends Entity {

    public Bomber(int x, int y, Image img) {
        super( x, y, img);
    }

    @Override
    public void update() {

    }
    public void moveUp() {
        y -= SCALED_SIZE;
    }
    public void moveDown() {
        y += SCALED_SIZE;
    }
    public void moveLeft() {
        x -= SCALED_SIZE;
    }
    public void moveRight() {
        x += SCALED_SIZE;
    }
}
