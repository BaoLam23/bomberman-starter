package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.control.Sound;
import uet.oop.bomberman.graphics.Sprite;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static uet.oop.bomberman.BombermanGame.*;
public class Bomb extends Entity {

    private static Entity bomb;
    private static Entity flameLeft;
    private static Entity flameRight;
    private static Entity flameDown;
    private static Entity flameTop;

    public static boolean hasBomb = false;
    public static boolean exploded = false;

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

            killObjects.add(bomb);
            stillObjects.add(bomb);

            Sound.bombPlaced();
            CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS).execute(() -> {
                Sound.bombBouncing();

                CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS).execute(Sound::bombBouncing);
            });


            CompletableFuture.delayedExecutor(2, TimeUnit.SECONDS).execute(() -> {
                Sound.bombExploding();
                exploded = true;

                flameLeft = new Flame(x - 1, y, Sprite.explosion_horizontal_left_last.getFxImage());
                flameRight = new Flame(x + 1, y, Sprite.explosion_horizontal_right_last.getFxImage());
                flameDown = new Flame(x, y + 1, Sprite.explosion_vertical_down_last.getFxImage());
                flameTop = new Flame(x, y - 1, Sprite.explosion_vertical_top_last.getFxImage());


                if (canExplode(x - 1, y)) {
                    killObjects.add(flameLeft);
                }


                if (canExplode(x + 1, y)) {
                    killObjects.add(flameRight);
                }


                if (canExplode(x , y + 1)) {
                    killObjects.add(flameDown);
                }


                if (canExplode(x, y - 1)) {
                    killObjects.add(flameTop);
                }
                breakBrick(x, y);
            });

            CompletableFuture.delayedExecutor(4, TimeUnit.SECONDS).execute(() -> {
                hasBomb = false;
                killObjects.clear();
                stillObjects.remove(bomb);
            });
        }
    }

    @Override
    public void update() {
        spriteCounter++;

        if (spriteCounter > 15) {
            if (spriteNum == 1 || spriteNum == 2)
                spriteNum++;

            else if (spriteNum == 3)
                spriteNum = 1;

            spriteCounter = 0;
        }

        if (!exploded) {
            if (getSpriteNum() == 1)
                bomb.setSprite(Sprite.bomb.getFxImage());

            if (getSpriteNum() == 2)
                bomb.setSprite(Sprite.bomb_1.getFxImage());

            if (getSpriteNum() == 3)
                bomb.setSprite(Sprite.bomb_2.getFxImage());
        }

        else {
            if (getSpriteNum() == 1) {
                bomb.setSprite(Sprite.bomb_exploded.getFxImage());

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
            if (x == Math.round(e.getX() / 32) && y == Math.round(e.getY() / 32)) {
                return e;
            }
        }
        return null;
    }

    private static boolean canExplode(int x, int y) {
        return !(getAt(x, y) instanceof Wall);
    }

    private static void breakBrick(int x, int y) {
        Brick b1 = null, b2 = null, b3 = null, b4 = null;
        Vase v1 = null, v2 = null, v3 = null, v4 = null;
        for (Entity e : stillObjects) {
            if (e instanceof Brick) {
                if (Math.round(e.getX() / 32) == x - 1 && Math.round(e.getY() / 32) == y) {
                    b1 = (Brick) e;
                }
                if (Math.round(e.getX() / 32) == x + 1 && Math.round(e.getY() / 32) == y) {
                    b2 = (Brick) e;
                }
                if (Math.round(e.getX() / 32) == x && Math.round(e.getY() / 32) == y + 1) {
                    b3 = (Brick) e;
                }
                if (Math.round(e.getX() / 32) == x && Math.round(e.getY() / 32) == y - 1) {
                    b4 = (Brick) e;
                }
            }
            if (e instanceof Vase) {
                if (Math.round(e.getX() / 32) == x - 1 && Math.round(e.getY() / 32) == y) {
                    v1 = (Vase) e;
                }
                if (Math.round(e.getX() / 32) == x + 1 && Math.round(e.getY() / 32) == y) {
                    v2 = (Vase) e;
                }
                if (Math.round(e.getX() / 32) == x && Math.round(e.getY() / 32) == y + 1) {
                    v3 = (Vase) e;
                }
                if (Math.round(e.getX() / 32) == x && Math.round(e.getY() / 32) == y - 1) {
                    v4 = (Vase) e;
                }
            }
        }
        if (b1 != null) {
            b1.isBroken = true;
            b1.setSpriteNum(1);
        }

        if (b2 != null) {
            b2.isBroken = true;
            b2.setSpriteNum(1);
        }

        if (b3 != null) {
            b3.isBroken = true;
            b3.setSpriteNum(1);
        }

        if (b4 != null){
            b4.isBroken = true;
            b4.setSpriteNum(1);
        }

        if (v1 != null) {
            v1.isBroken = true;
            v1.setSpriteNum(1);
        }

        if (v2 != null) {
            v2.isBroken = true;
            v2.setSpriteNum(1);
        }

        if (v3 != null) {
            v3.isBroken = true;
            v3.setSpriteNum(1);
        }

        if (v4 != null){
            v4.isBroken = true;
            v4.setSpriteNum(1);
        }

        Brick finalB = b1;
        Brick finalB1 = b2;
        Brick finalB2 = b3;
        Brick finalB3 = b4;
        Vase finalV1 = v1;
        Vase finalV = v2;
        Vase finalV2 = v3;
        Vase finalV3 = v4;
        CompletableFuture.delayedExecutor(2, TimeUnit.SECONDS).execute(() -> {
            if (finalB != null) stillObjects.remove(finalB);
            if (finalB1 != null) stillObjects.remove(finalB1);
            if (finalB2 != null) stillObjects.remove(finalB2);
            if (finalB3 != null) stillObjects.remove(finalB3);
            if (finalV1 != null) stillObjects.remove(finalV1);
            if (finalV != null) stillObjects.remove(finalV);
            if (finalV2 != null) stillObjects.remove(finalV2);
            if (finalV3 != null) stillObjects.remove(finalV3);
        });
    }
}
