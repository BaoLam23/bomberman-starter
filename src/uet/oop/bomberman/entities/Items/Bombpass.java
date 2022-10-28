package uet.oop.bomberman.entities.Items;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Grass;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.BombermanGame.bomberman;

public class Bombpass extends Item {
    public Bombpass(int x, int y, Image img) {
        super(x, y, img);
    }

    public Bombpass(boolean getItem) {
        super(getItem);
    }

    @Override
    public void setSprite(Image newSprite) {
    }

    @Override
    public void update() {
        for (int i = 0; i < itemsList.size(); i++) {
            if (itemsList.get(i) instanceof Bombpass) {
                int x = itemsList.get(i).getX();
                int y = itemsList.get(i).getY();
                if (bomberman.getX() == x && bomberman.getY() == y) {
                    itemsList.remove(itemsList.get(i));
                    Entity object = new Grass(x / 32, y / 32, Sprite.grass.getFxImage());
                    stillObjects.add(object);
                    bomberman.setBombPass(true);
                }
            }
        }
//        for (Entity entity : itemsList) {
//            int x = entity.getX();
//            int y = entity.getY();
//            if (bomberman.getX() == x && bomberman.getY() == y) {
//                itemsList.remove(entity);
//                Entity object = new Grass(x / 32, y / 32, Sprite.grass.getFxImage());
//                stillObjects.add(object);
//                bomberman.setBombPass(true);
//            }
//        }
    }
}
