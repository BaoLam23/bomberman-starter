package uet.oop.bomberman.entities.Animals;

import javafx.scene.image.Image;
import uet.oop.bomberman.control.Sound;
import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.BombermanGame.entities;

public class Balloom extends Animal {
    private int moveNum = 1;
    private boolean isFacingLeft = false;

    public Balloom(int x, int y, Image img) {
        super(x, y, img);
    }

    public void bombKillBalloom() {
        entities.remove(this);
        Sound.enemyDying();
    }

    @Override
    public void update() {
        spriteCounter++;

        if (spriteCounter > 20) {
            if (spriteNum == 1 || spriteNum == 2)
                spriteNum++;

            else if (spriteNum == 3)
                spriteNum = 1;

            spriteCounter = 0;
        }

        if (!isFacingLeft) {
            if (spriteNum == 1)
                setSprite(Sprite.balloom_right1.getFxImage());

            if (spriteNum == 2)
                setSprite(Sprite.balloom_right2.getFxImage());

            if (spriteNum == 3)
                setSprite(Sprite.balloom_right3.getFxImage());
        }

        else {
            if (spriteNum == 1)
                setSprite(Sprite.balloom_left1.getFxImage());

            if (spriteNum == 2)
                setSprite(Sprite.balloom_left2.getFxImage());

            if (spriteNum == 3)
                setSprite(Sprite.balloom_left3.getFxImage());
        }
        checkBomb(this);
        checkTrap(this);
        if (!this.isLife()) {
            this.bombKillBalloom();
        }

        moveNum++;

        int dir = (int) (Math.random() * 4 + 1);
        if(moveNum > 60) {
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
