package uet.oop.bomberman.entities.Items;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Grass;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;

public class Wallpass extends Item {
    public Wallpass(int x, int y, Image img) {
        super(x, y, img);
    }

    public Wallpass(boolean getItem) {
        super(getItem);
    }

    @Override
    public void setSprite(Image newSprite) {
    }

    @Override
    public void update() {
        for (int i = 0; i < itemsList.size(); i++) {
            if (itemsList.get(i) instanceof Wallpass) {
                int x = itemsList.get(i).getX();
                int y = itemsList.get(i).getY();
                if (bomberman.getX() == x && bomberman.getY() == y) {
                    Entity object = new Grass(x / 32, y / 32, Sprite.grass.getFxImage());
                    stillObjects.add(object);
                    bomberman.setThrough(true);
                    itemsList.remove(itemsList.get(i));
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
//                bomberman.setThrough(true);
//                System.out.println(bomberman.isThrough());
//            }
//        }
    }
}
