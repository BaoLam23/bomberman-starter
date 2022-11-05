package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.control.Sound;
import uet.oop.bomberman.entities.Items.Flamepass;
import uet.oop.bomberman.graphics.Sprite;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static uet.oop.bomberman.BombermanGame.*;
public class Bomb extends Entity {

    private static Entity bomb;
    private static Entity flameLeft, flameLeft2;
    private static Entity flameRight, flameRight2;
    private static Entity flameDown, flameDown2;
    private static Entity flameTop, flameTop2;

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
                flameLeft2 = new Flame(x - 2, y, Sprite.explosion_horizontal_left_last.getFxImage());

                flameRight = new Flame(x + 1, y, Sprite.explosion_horizontal_right_last.getFxImage());
                flameRight2 = new Flame(x + 2, y, Sprite.explosion_horizontal_right_last.getFxImage());

                flameDown = new Flame(x, y + 1, Sprite.explosion_vertical_down_last.getFxImage());
                flameDown2 = new Flame(x, y + 2, Sprite.explosion_vertical_down_last.getFxImage());

                flameTop = new Flame(x, y - 1, Sprite.explosion_vertical_top_last.getFxImage());
                flameTop2 = new Flame(x, y - 2, Sprite.explosion_vertical_top_last.getFxImage());


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

                if(Flamepass.getRemainingPasses() > 0) {
                    if (canExplode(x - 2, y) && canExplode(x - 1, y)) {
                        killObjects.add(flameLeft2);
                    }

                    if (canExplode(x + 2, y) && canExplode(x + 1, y)) {
                        killObjects.add(flameRight2);
                    }

                    if (canExplode(x , y + 2) && canExplode(x , y + 1)) {
                        killObjects.add(flameDown2);
                    }

                    if (canExplode(x, y - 2) && canExplode(x, y - 1)) {
                        killObjects.add(flameTop2);
                    }
                }

                breakBrick(x, y);
                breakVase(x, y);
            });

            CompletableFuture.delayedExecutor(4, TimeUnit.SECONDS).execute(() -> {
                hasBomb = false;
                if (canExplode(x - 1, y)) {
                    killObjects.remove(flameLeft);
                }

                if (canExplode(x + 1, y)) {
                    killObjects.remove(flameRight);
                }

                if (canExplode(x , y + 1)) {
                    killObjects.remove(flameDown);
                }

                if (canExplode(x, y - 1)) {
                    killObjects.remove(flameTop);
                }

                if(Flamepass.getRemainingPasses() > 0) {
                    Flamepass.setRemainingPasses(Flamepass.getRemainingPasses() - 1);

                    if (canExplode(x - 2, y) && canExplode(x - 1, y)) {
                        killObjects.remove(flameLeft2);
                    }

                    if (canExplode(x + 2, y) && canExplode(x + 1, y)) {
                        killObjects.remove(flameRight2);
                    }

                    if (canExplode(x , y + 2) && canExplode(x , y + 1)) {
                        killObjects.remove(flameDown2);
                    }

                    if (canExplode(x, y - 2) && canExplode(x, y - 1)) {
                        killObjects.remove(flameTop2);
                    }
                }

                killObjects.remove(bomb);
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
                flameLeft2.setSprite(Sprite.explosion_horizontal_left_last.getFxImage());

                flameRight.setSprite(Sprite.explosion_horizontal_right_last.getFxImage());
                flameRight2.setSprite(Sprite.explosion_horizontal_right_last.getFxImage());

                flameDown.setSprite(Sprite.explosion_vertical_down_last.getFxImage());
                flameDown2.setSprite(Sprite.explosion_vertical_down_last.getFxImage());

                flameTop.setSprite(Sprite.explosion_vertical_top_last.getFxImage());
                flameTop2.setSprite(Sprite.explosion_vertical_top_last.getFxImage());
            }

            if (getSpriteNum() == 2) {
                setSprite(Sprite.bomb_exploded1.getFxImage());

                flameLeft.setSprite(Sprite.explosion_horizontal_left_last1.getFxImage());
                flameLeft2.setSprite(Sprite.explosion_horizontal_left_last1.getFxImage());

                flameRight.setSprite(Sprite.explosion_horizontal_right_last1.getFxImage());
                flameRight2.setSprite(Sprite.explosion_horizontal_right_last1.getFxImage());

                flameDown.setSprite(Sprite.explosion_vertical_down_last1.getFxImage());
                flameDown2.setSprite(Sprite.explosion_vertical_down_last1.getFxImage());

                flameTop.setSprite(Sprite.explosion_vertical_top_last1.getFxImage());
                flameTop2.setSprite(Sprite.explosion_vertical_top_last1.getFxImage());
            }

            if (getSpriteNum() == 3) {
                setSprite(Sprite.bomb_exploded2.getFxImage());

                flameLeft.setSprite(Sprite.explosion_horizontal_left_last2.getFxImage());
                flameLeft2.setSprite(Sprite.explosion_horizontal_left_last2.getFxImage());

                flameRight.setSprite(Sprite.explosion_horizontal_right_last2.getFxImage());
                flameRight2.setSprite(Sprite.explosion_horizontal_right_last2.getFxImage());

                flameDown.setSprite(Sprite.explosion_vertical_down_last2.getFxImage());
                flameDown2.setSprite(Sprite.explosion_vertical_down_last2.getFxImage());

                flameTop.setSprite(Sprite.explosion_vertical_top_last2.getFxImage());
                flameTop2.setSprite(Sprite.explosion_vertical_top_last2.getFxImage());
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
        Brick b5 = null, b6 = null, b7 = null, b8 = null;
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

                if (Math.round(e.getX() / 32) == x - 2 && Math.round(e.getY() / 32) == y) {
                    b5 = (Brick) e;
                }
                if (Math.round(e.getX() / 32) == x + 2 && Math.round(e.getY() / 32) == y) {
                    b6 = (Brick) e;
                }
                if (Math.round(e.getX() / 32) == x && Math.round(e.getY() / 32) == y + 2) {
                    b7 = (Brick) e;
                }
                if (Math.round(e.getX() / 32) == x && Math.round(e.getY() / 32) == y - 2) {
                    b8 = (Brick) e;
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

        if (Flamepass.getRemainingPasses() > 0) {
            if (b5 != null) {
                b5.isBroken = true;
                b5.setSpriteNum(1);
            }

            if (b6 != null) {
                b6.isBroken = true;
                b6.setSpriteNum(1);
            }

            if (b7 != null) {
                b7.isBroken = true;
                b7.setSpriteNum(1);
            }

            if (b8 != null){
                b8.isBroken = true;
                b8.setSpriteNum(1);
            }
        }

        Brick finalB1 = b1;
        Brick finalB2 = b2;
        Brick finalB3 = b3;
        Brick finalB4 = b4;

        Brick finalB5 = b5;
        Brick finalB6 = b6;
        Brick finalB7 = b7;
        Brick finalB8 = b8;

        CompletableFuture.delayedExecutor(2, TimeUnit.SECONDS).execute(() -> {
            if (finalB1 != null) {
                stillObjects.remove(finalB1);
            }

            if (finalB2 != null) {
                stillObjects.remove(finalB2);
            }

            if (finalB3 != null) {
                stillObjects.remove(finalB3);
            }

            if (finalB4 != null){
                stillObjects.remove(finalB4);
            }

            if (Flamepass.getRemainingPasses() > 0) {
                if (finalB5 != null) {
                    stillObjects.remove(finalB5);
                }

                if (finalB6 != null) {
                    stillObjects.remove(finalB6);
                }

                if (finalB7 != null) {
                    stillObjects.remove(finalB7);
                }

                if (finalB8 != null){
                    stillObjects.remove(finalB8);
                }
            }
        });
    }

    private static void breakVase(int x, int y) {
        Vase v1 = null, v2 = null, v3 = null, v4 = null;
        Vase v5 = null, v6 = null, v7 = null, v8 = null;
        for (Entity e : stillObjects) {
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

                if (Math.round(e.getX() / 32) == x - 2 && Math.round(e.getY() / 32) == y) {
                    v5 = (Vase) e;
                }
                if (Math.round(e.getX() / 32) == x + 2 && Math.round(e.getY() / 32) == y) {
                    v6 = (Vase) e;
                }
                if (Math.round(e.getX() / 32) == x && Math.round(e.getY() / 32) == y + 2) {
                    v7 = (Vase) e;
                }
                if (Math.round(e.getX() / 32) == x && Math.round(e.getY() / 32) == y - 2) {
                    v8 = (Vase) e;
                }
            }
        }
        if (v1 != null) {
            v1.isBroken = true;
            v1.setSpriteNum(1);
            Sound.vaseBreaking();
        }

        if (v2 != null) {
            v2.isBroken = true;
            v2.setSpriteNum(1);
            Sound.vaseBreaking();
        }

        if (v3 != null) {
            v3.isBroken = true;
            v3.setSpriteNum(1);
            Sound.vaseBreaking();
        }

        if (v4 != null){
            v4.isBroken = true;
            v4.setSpriteNum(1);
            Sound.vaseBreaking();
        }

        if (Flamepass.getRemainingPasses() > 0) {
            if (v5 != null) {
                v5.isBroken = true;
                v5.setSpriteNum(1);
                Sound.vaseBreaking();
            }

            if (v6 != null) {
                v6.isBroken = true;
                v6.setSpriteNum(1);
                Sound.vaseBreaking();
            }

            if (v7 != null) {
                v7.isBroken = true;
                v7.setSpriteNum(1);
                Sound.vaseBreaking();
            }

            if (v8 != null){
                v8.isBroken = true;
                v8.setSpriteNum(1);
                Sound.vaseBreaking();
            }
        }

        Vase finalV1 = v1;
        Vase finalV2 = v2;
        Vase finalV3 = v3;
        Vase finalV4 = v4;

        Vase finalV5 = v5;
        Vase finalV6 = v6;
        Vase finalV7 = v7;
        Vase finalV8 = v8;

        CompletableFuture.delayedExecutor(2, TimeUnit.SECONDS).execute(() -> {
            if (finalV1 != null) {
                stillObjects.remove(finalV1);
            }

            if (finalV2 != null) {
                stillObjects.remove(finalV2);
            }

            if (finalV3 != null) {
                stillObjects.remove(finalV3);
            }

            if (finalV4 != null){
                stillObjects.remove(finalV4);
            }

            if (Flamepass.getRemainingPasses() > 0) {
                if (finalV5 != null) {
                    stillObjects.remove(finalV5);
                }

                if (finalV6 != null) {
                    stillObjects.remove(finalV6);
                }

                if (finalV7 != null) {
                    stillObjects.remove(finalV7);
                }

                if (finalV8 != null){
                    stillObjects.remove(finalV8);
                }
            }
        });
    }
}