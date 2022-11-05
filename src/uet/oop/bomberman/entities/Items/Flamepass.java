package uet.oop.bomberman.entities.Items;

import javafx.scene.image.Image;
import uet.oop.bomberman.control.Sound;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Grass;
import uet.oop.bomberman.graphics.Sprite;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.BombermanGame.bomberman;

public class Flamepass extends Item {
    private static boolean hasFlamePass = false;
    private static int remainingPasses = 0;

    public Flamepass(int x, int y, Image img) {
        super(x, y, img);
    }


    public static int getRemainingPasses() {
        return remainingPasses;
    }

    public static void setRemainingPasses(int remainingPasses) {
        Flamepass.remainingPasses = remainingPasses;
    }

    @Override
    public void setSprite(Image newSprite) {
    }

    @Override
    public void update() {

        for (int i = 0; i < itemsList.size(); i++) {
            if (itemsList.get(i) instanceof Flamepass) {
                int x = itemsList.get(i).getX();
                int y = itemsList.get(i).getY();
                if (bomberman.getX() == x && bomberman.getY() == y) {
                    hasFlamePass = true;
                    remainingPasses = 5;

                    Sound.powerUp();
                    itemsList.remove(itemsList.get(i));
                    Entity object = new Grass(x / 32, y / 32, Sprite.grass.getFxImage());
                    stillObjects.add(object);
                    bomberman.setBombPass(true);
                }
            }
        }
    }
}
