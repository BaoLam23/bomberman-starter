package uet.oop.bomberman.entities.Animals;

import javafx.scene.image.Image;
import uet.oop.bomberman.control.Sound;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.entities;

public class Doll extends Animal {
    private int moveNum = 1;
    private boolean isFacingLeft = false;

    public Doll(int x, int y, Image img) {
        super(x, y, img);
    }

    public void bombKillDoll() {
        entities.remove(this);
        Sound.enemyDying();
    }

    @Override
    public void update() {
        if (!this.isThrough()) {
            this.setThrough(true);
        }
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
                setSprite(Sprite.doll_right1.getFxImage());

            if (spriteNum == 2)
                setSprite(Sprite.doll_right2.getFxImage());

            if (spriteNum == 3)
                setSprite(Sprite.doll_right3.getFxImage());
        }

        else {
            if (spriteNum == 1)
                setSprite(Sprite.doll_left1.getFxImage());

            if (spriteNum == 2)
                setSprite(Sprite.doll_left2.getFxImage());

            if (spriteNum == 3)
                setSprite(Sprite.doll_left3.getFxImage());
        }
        checkBomb(this);
        checkTrap(this);
        if (!this.isLife()) {
            this.bombKillDoll();
        }

        moveNum++;

        int dir = (int) (Math.random() * 4 + 1);
        if(moveNum > 120) {
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
