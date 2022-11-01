package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

public class Grass extends Entity {

    public Grass(int x, int y, Image img) {
        super(x, y, img);
    }

    public static Image selectGrass() {
        int tmp = (int) (Math.random() * 10 + 1);
        Image img = null;
        switch (tmp) {
            case 1: {
                img = Sprite.grass1.getFxImage();
                return img;
            }
            case 2: {
                img = Sprite.grass2.getFxImage();
                return img;
            }
            case 3: {
                img = Sprite.grass3.getFxImage();
                return img;
            }
            default: {
                img = Sprite.grass.getFxImage();
                return img;
            }
        }
    }
    @Override
    public void setSprite(Image newSprite) {
    }

    @Override
    public void update() {

    }
}
