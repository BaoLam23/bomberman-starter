package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static uet.oop.bomberman.BombermanGame.*;

public class Bomb extends Entity {

    private static Entity bomb;
    public static boolean hasBomb = false;

    public Bomb(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void setSprite(Image newSprite) {
        img = newSprite;
    }

    public static void putBomb() {
        if (!hasBomb) {
            int x = Math.round(bomberman.getX() / 32);
            int y = Math.round(bomberman.getY() / 32);
            bomb = new Bomb(x, y, Sprite.bomb.getFxImage());
            //bomb = new Bomb(x, y, Sprite.bomb_exploded2.getFxImage());
            stillObjects.add(bomb);
            hasBomb = true;
            CompletableFuture.delayedExecutor(3, TimeUnit.SECONDS).execute(() -> {
                // Your code here executes after 3 seconds!
                stillObjects.remove(bomb);
                bomb = new Bomb(x, y, Sprite.bomb_exploded2.getFxImage());
                killObjects.add(bomb);
                hasBomb = false;
            });
        }
    }


    @Override
    public void update() {

    }
}
