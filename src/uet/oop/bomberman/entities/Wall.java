package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

public class Wall extends Entity {

    public Wall(int x, int y, Image img) {
        super(x, y, img);
    }

    public static Image selectWall() {
        int tmp = (int) (Math.random() * 30 + 1);
        Image img = null;
        switch (tmp) {
            case 1: {
                img = Sprite.table.getFxImage();
                return img;
            }
            case 2: {
                img = Sprite.chair.getFxImage();
                return img;
            }
            default: {
                img = Sprite.wall.getFxImage();
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
