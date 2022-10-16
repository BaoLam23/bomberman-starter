package uet.oop.bomberman.entities.Animals;

import javafx.scene.image.Image;
import uet.oop.bomberman.control.Sound;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static uet.oop.bomberman.BombermanGame.entities;
import static uet.oop.bomberman.BombermanGame.stillObjects;

public class Oneal extends Animal {
    private int moveNum = 1;

    private boolean isFacingLeft = false;

    public Oneal(int x, int y, Image img) {
        super(x, y, img);
    }

    public void bombKillOnel() {
        //this.setSprite(Sprite.Oneal_dead.getFxImage());
        entities.remove(this);
    }
    @Override
    public void update() {
        checkBomb(this);
        if (!this.isLife()) {
            this.bombKillOnel();
        }
//        for (Entity e : entities) {
//            if (e instanceof Balloom) {
//                ((Balloom) e).moveLeft();
//                System.out.println("found");
//            }
//        }

        spriteCounter++;

        if (spriteCounter > 10) {
            if (spriteNum == 1 || spriteNum == 2)
                spriteNum++;

            else if (spriteNum == 3)
                spriteNum = 1;

            spriteCounter = 0;
        }

        if (!isFacingLeft) {
            if (spriteNum == 1)
                setSprite(Sprite.oneal_right1.getFxImage());

            if (spriteNum == 2)
                setSprite(Sprite.oneal_right2.getFxImage());

            if (spriteNum == 3)
                setSprite(Sprite.oneal_right3.getFxImage());
        }

        else {
            if (spriteNum == 1)
                setSprite(Sprite.oneal_left1.getFxImage());

            if (spriteNum == 2)
                setSprite(Sprite.oneal_left2.getFxImage());

            if (spriteNum == 3)
                setSprite(Sprite.oneal_left3.getFxImage());
        }

        moveNum++;

        int dir = (int) (Math.random() * 4 + 1);
        if(moveNum > 40) {
            switch (dir) {
                case 1: {
                    this.moveLeft();
                    isFacingLeft = true;
                    break;
                }
                case 2: {
                    this.moveRight();
                    isFacingLeft = false;
                    break;
                }
                case 3: {
                    this.moveUp();
                    break;
                }
                case 4: {
                    this.moveDown();
                    break;
                }
            }

            moveNum = 1;
        }
    }

    @Override
    public void setSprite(Image newSprite) {
        img = newSprite;
    }

}
