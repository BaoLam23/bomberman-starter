package uet.oop.bomberman.entities.Items;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Grass;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.BombermanGame.bomberman;

public class Random extends Item {
    public Random(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void setSprite(Image newSprite) {
    }

    @Override
    public void update() {
        for (int i = 0; i < itemsList.size(); i++) {
            Entity entity = itemsList.get(i);
            if (entity instanceof Random) {
                int x = entity.getX();
                int y = entity.getY();
                if (bomberman.getX() == x && bomberman.getY() == y) {
                    itemsList.remove(entity);
                    Entity object = new Grass(x / 32, y / 32, Sprite.grass.getFxImage());
                    stillObjects.add(object);
                    int random = (int) (Math.random() * 2 + 1);
                    switch (random) {
                        case 1: {
                            bomberman.setBombPass(true);
                            break;
                        }
                        case 2: {
                            bomberman.setThrough(true);
                            break;
                        }
                    }
                }
            }
        }
    }
}
