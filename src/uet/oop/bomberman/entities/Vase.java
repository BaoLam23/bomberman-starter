package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

public class Vase extends Entity {
    public boolean isBroken = false;
    public Vase(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void setSprite(Image newSprite) {
        img = newSprite;
    }

    @Override
    public void update() {
        spriteCounter++;

        if (spriteCounter > 50) {
            if (spriteNum == 1 || spriteNum == 2)
                spriteNum++;

            else if (spriteNum == 3)
                spriteNum = 1;

            spriteCounter = 0;
        }

        if (isBroken) {
            if (getSpriteNum() == 1)
                setSprite(Sprite.vase.getFxImage());

            if (getSpriteNum() == 2)
                setSprite(Sprite.vase_broken.getFxImage());

            if (getSpriteNum() == 3)
                setSprite(Sprite.vase_broken2.getFxImage());
        }
    }
}
