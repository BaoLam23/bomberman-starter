package uet.oop.bomberman.entities.Decor;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public class Torch extends Entity {
    public Torch(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }


    @Override
    public void update() {
        spriteCounter++;

        if (spriteCounter > 15) {
            if (spriteNum == 1 || spriteNum == 2)
                spriteNum++;

            else if (spriteNum == 3)
                spriteNum = 1;

            spriteCounter = 0;
        }


        if (getSpriteNum() == 1)
            setSprite(Sprite.torch.getFxImage());
        if (getSpriteNum() == 2)
            setSprite(Sprite.torch1.getFxImage());
        if (getSpriteNum() == 3)
            setSprite(Sprite.torch2.getFxImage());

    }

    @Override
    public void setSprite(Image newSprite) {
        img = newSprite;
    }
}
