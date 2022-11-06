package uet.oop.bomberman.entities.Items;

import javafx.scene.image.Image;
import uet.oop.bomberman.control.Menu;
import uet.oop.bomberman.control.Sound;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Grass;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.BombermanGame.bomberman;

public class ExtraLife extends Item {
    public ExtraLife(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void setSprite(Image newSprite) {
    }

    @Override
    public void update() {
        for (int i = 0; i < itemsList.size(); i++) {
            if (itemsList.get(i) instanceof ExtraLife) {
                int x = itemsList.get(i).getX();
                int y = itemsList.get(i).getY();
                if (bomberman.getX() == x && bomberman.getY() == y) {
                    Sound.powerUp();
                    itemsList.remove(itemsList.get(i));
                    Entity object = new Grass(x / 32, y / 32, Sprite.grass.getFxImage());
                    stillObjects.add(object);
                    bomberman.setNumOfLives(bomberman.getNumOfLives() + 1);
                }
            }
        }
    }
}
