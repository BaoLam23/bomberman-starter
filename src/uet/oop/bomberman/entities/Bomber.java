package uet.oop.bomberman.entities;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Bomber extends Entity {

    public Bomber(int x, int y, Image img) {
        super( x, y, img);
    }

    @Override
    public void update() {
        spriteCounter++;

        if (spriteCounter > 10) {
            if (spriteNum == 1 || spriteNum == 2)
                spriteNum++;

            else if (spriteNum == 3)
                spriteNum = 1;

            spriteCounter = 0;
        }
    }

    @Override
    public void setSprite(Image newSprite) {
        img = newSprite;
    }

    public void moveUp() {
        y -= 32;
    }
    public void moveDown() {
        y += 32;
    }
    public void moveLeft() {
        x -= 32;
    }
    public void moveRight() {
        x +=32;
    }
}
