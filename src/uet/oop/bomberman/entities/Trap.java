package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.control.Sound;
import uet.oop.bomberman.graphics.Sprite;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.BombermanGame.stillObjects;

public class Trap extends Entity {
    public Trap() {}
    public Trap(int x, int y, Image img) {
        super(x, y, img);
    }

    public static void putTrap() {
        if (numOfTraps > 0) {
            int x = bomberman.getX() / 32;
            int y = bomberman.getY() / 32;

            Trap trap = new Trap(x, y, Sprite.trap.getFxImage());
            numOfTraps--;
            CompletableFuture.delayedExecutor(150, TimeUnit.MILLISECONDS).execute(() -> {
                trap.setSprite(Sprite.trap1.getFxImage());
                Sound.trapPlaced();

                CompletableFuture.delayedExecutor(150, TimeUnit.MILLISECONDS).execute(() -> {
                    trap.setSprite(Sprite.trap2.getFxImage());

                    CompletableFuture.delayedExecutor(150, TimeUnit.MILLISECONDS).execute(() -> {
                        trap.setSprite(Sprite.trap3.getFxImage());
                    });
                });
            });

            killObjects.add(trap);
        }
    }

    @Override
    public void setSprite(Image newSprite) {
        img = newSprite;
    }

    @Override
    public void update() {

    }
}

