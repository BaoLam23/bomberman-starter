package uet.oop.bomberman.entities.Animals;

import javafx.scene.image.Image;
import uet.oop.bomberman.AI.AStar;
import uet.oop.bomberman.AI.Node;
import uet.oop.bomberman.control.Blocked;
import uet.oop.bomberman.control.Sound;
import uet.oop.bomberman.entities.Brick;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Wall;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.BombermanGame.stillObjects;

public class Minvo extends Animal {
    private int moveNum = 1;

    public Minvo(int x, int y, Image img) {
        super(x, y, img);
    }

    public void bombKillMinvo() {
        Sound.enemyDying();
        entities.remove(this);
    }

    private double calDistance(int x, int y) {
        int x_ = bomberman.getX();
        int y_ = bomberman.getY();
        return Math.sqrt(Math.pow(x_ - x, 2) + Math.pow(y_ - y, 2));
    }

    public void findBomberman() {
        double up = calDistance(this.getX(), this.getY() - 32);
        double down = calDistance(this.getX(), this.getY() + 32);
        double left = calDistance(this.getX() - 32, this.getY());
        double right = calDistance(this.getX() + 32, this.getY());
        ArrayList<Double> a = new ArrayList<Double>();
        if (!Blocked.blockedUp(this)) {
            a.add(up);
        }
        if (!Blocked.blockedDown(this)) {
            a.add(down);
        }
        if (!Blocked.blockedLeft(this)) {
            a.add(left);
        }
        if (!Blocked.blockedRight(this)) {
            a.add(right);
        }
        double tmp = -1;
        if (a.size() != 0) {
            Collections.sort(a);
            tmp = a.get(0);
        }
        if (tmp == up) {
            this.moveUp();
        } else if(tmp == down) {
            this.moveDown();
        } else if(tmp == left) {
            this.moveLeft();
        } else if(tmp == right) {
            this.moveRight();
        }

    }
    @Override
    public void update() {
        checkBomb(this);
        if (!this.isLife()) {
            this.bombKillMinvo();
        }

        spriteCounter++;

        if (spriteCounter > 10) {
            if (spriteNum == 1 || spriteNum == 2)
                spriteNum++;

            else if (spriteNum == 3)
                spriteNum = 1;

            spriteCounter = 0;
        }

        boolean isFacingLeft = false;
        if (!isFacingLeft) {
            if (spriteNum == 1)
                setSprite(Sprite.minvo_right1.getFxImage());

            if (spriteNum == 2)
                setSprite(Sprite.minvo_right2.getFxImage());

            if (spriteNum == 3)
                setSprite(Sprite.minvo_right3.getFxImage());
        }

        else {
            if (spriteNum == 1)
                setSprite(Sprite.minvo_left1.getFxImage());

            if (spriteNum == 2)
                setSprite(Sprite.minvo_left2.getFxImage());

            if (spriteNum == 3)
                setSprite(Sprite.minvo_left3.getFxImage());
        }

        moveNum++;

        if(moveNum > 40) {
            this.findBomberman();
            moveNum = 1;
        }
    }

    @Override
    public void setSprite(Image newSprite) {
        img = newSprite;
    }

}
