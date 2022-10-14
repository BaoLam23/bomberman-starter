package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.control.Sound;
import uet.oop.bomberman.graphics.Sprite;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.graphics.Sprite.SCALED_SIZE;
public class Bomb extends Entity {

    private static Entity bomb;
    private static Entity flameLeft;
    private static Entity flameRight;
    private static Entity flameDown;
    private static Entity flameTop;

    public static boolean hasBomb = false;
    private static boolean exploded = false;

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
            hasBomb = true;
            exploded = false;

            //bomb = new Bomb(x, y, Sprite.bomb_exploded2.getFxImage());
            stillObjects.add(bomb);

            Sound.bombPlaced();
            CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS).execute(() -> {
                Sound.bombBouncing();

                CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS).execute(Sound::bombBouncing);
            });


            CompletableFuture.delayedExecutor(3, TimeUnit.SECONDS).execute(() -> {
                // Your code here executes after 3 seconds!
//                stillObjects.remove(bomb);
//                bomb = new Bomb(x, y, Sprite.bomb_exploded2.getFxImage());
//                stillObjects.add(bomb);

                Sound.bombExploding();
                exploded = true;

                flameLeft = new Flame(x - 1, y, Sprite.explosion_horizontal_left_last.getFxImage());
                flameRight = new Flame(x + 1, y, Sprite.explosion_horizontal_right_last.getFxImage());
                flameDown = new Flame(x, y + 1, Sprite.explosion_vertical_down_last.getFxImage());
                flameTop = new Flame(x, y - 1, Sprite.explosion_vertical_top_last.getFxImage());


                if (canExplode(x - 1, y))
                    stillObjects.add(flameLeft);

                if (canExplode(x + 1, y))
                    stillObjects.add(flameRight);

                if (canExplode(x + 1, y))
                    stillObjects.add(flameDown);

                if (canExplode(x, y - 1))
                    stillObjects.add(flameTop);
            });

            CompletableFuture.delayedExecutor(4, TimeUnit.SECONDS).execute(() -> {
                hasBomb = false;
                stillObjects.remove(bomb);

                if (canExplode(x - 1, y))
                    stillObjects.remove(flameLeft);

                if (canExplode(x + 1, y))
                    stillObjects.remove(flameRight);

                if (canExplode(x, y + 1))
                    stillObjects.remove(flameDown);

                if (canExplode(x, y - 1))
                    stillObjects.remove(flameTop);
            });
        }
    }

    @Override
    public void update() {
        spriteCounter++;

        if (spriteCounter > 10) {
            if (spriteNum == 1 || spriteNum == 2)
                spriteNum++;

            else if (spriteNum == 3)
                spriteNum = 1;

            spriteCounter = 0;
        }

        if (!exploded) {
            if (getSpriteNum() == 1)
                setSprite(Sprite.bomb.getFxImage());

            if (getSpriteNum() == 2)
                setSprite(Sprite.bomb_1.getFxImage());

            if (getSpriteNum() == 3)
                setSprite(Sprite.bomb_2.getFxImage());
        }

        else {
            if (getSpriteNum() == 1) {
                setSprite(Sprite.bomb_exploded.getFxImage());

                flameLeft.setSprite(Sprite.explosion_horizontal_left_last.getFxImage());
                flameRight.setSprite(Sprite.explosion_horizontal_right_last.getFxImage());
                flameDown.setSprite(Sprite.explosion_vertical_down_last.getFxImage());
                flameTop.setSprite(Sprite.explosion_vertical_top_last.getFxImage());
            }

            if (getSpriteNum() == 2) {
                setSprite(Sprite.bomb_exploded1.getFxImage());

                flameLeft.setSprite(Sprite.explosion_horizontal_left_last1.getFxImage());
                flameRight.setSprite(Sprite.explosion_horizontal_right_last1.getFxImage());
                flameDown.setSprite(Sprite.explosion_vertical_down_last1.getFxImage());
                flameTop.setSprite(Sprite.explosion_vertical_top_last1.getFxImage());
            }

            if (getSpriteNum() == 3) {
                setSprite(Sprite.bomb_exploded2.getFxImage());

                flameLeft.setSprite(Sprite.explosion_horizontal_left_last2.getFxImage());
                flameRight.setSprite(Sprite.explosion_horizontal_right_last2.getFxImage());
                flameDown.setSprite(Sprite.explosion_vertical_down_last2.getFxImage());
                flameTop.setSprite(Sprite.explosion_vertical_top_last2.getFxImage());
            }

        }
    }

    public static Entity getAt(int x, int y) {
        for (Entity e : stillObjects) {
//            if (x == e.getX() && y == e.getY()) {
//                return e;
//            }
            if (x == Math.round(e.getX() / 32) && y == Math.round(e.getY() / 32)) {
                return e;
            }
        }
        return null;
    }

    private static boolean canExplode(int x, int y) {
        if (getAt(x, y) instanceof Wall)
            return false;

        return true;
    }
}
