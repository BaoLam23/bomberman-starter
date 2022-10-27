package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

public class Brick extends Entity {
    public boolean isBroken = false;
    public Brick(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void setSprite(Image newSprite) {
        img = newSprite;
    }

    @Override
    public void update() {
        spriteCounter++;

        if (spriteCounter > 100) {
            if (spriteNum == 1 || spriteNum == 2)
                spriteNum++;

            else if (spriteNum == 3)
                spriteNum = 1;

            spriteCounter = 0;
        }

        if (isBroken) {
            if (getSpriteNum() == 1)
                setSprite(Sprite.brick_exploded.getFxImage());

            if (getSpriteNum() == 2)
                setSprite(Sprite.brick_exploded1.getFxImage());

            if (getSpriteNum() == 3)
                setSprite(Sprite.brick_exploded2.getFxImage());
        }
    }
}
