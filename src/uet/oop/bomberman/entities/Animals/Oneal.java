package uet.oop.bomberman.entities.Animals;

import javafx.scene.image.Image;
import uet.oop.bomberman.AI.AStar;
import uet.oop.bomberman.AI.Node;
import uet.oop.bomberman.control.Sound;
import uet.oop.bomberman.entities.Brick;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Wall;
import uet.oop.bomberman.graphics.Sprite;

import java.util.List;

import static uet.oop.bomberman.BombermanGame.*;

public class Oneal extends Animal {
    private int moveNum = 1;

    public Oneal(int x, int y, Image img) {
        super(x, y, img);
    }

    public void bombKillOnel() {
        Sound.enemyDying();
        entities.remove(this);
    }

    public void findBomberman() {
        if (!bomberman.isLife()) return;
        Node bombermanPos = new Node(bomberman.getY() / 32, bomberman.getX() / 32);
        Node onealPos = new Node(this.getY() / 32, this.getX() / 32);

        AStar aStar = new AStar(HEIGHT, WIDTH, onealPos, bombermanPos);

        int[][] blocksArray = new int[WIDTH * HEIGHT][2];
        int countBlock = 0;

        for (Entity entity : stillObjects) {
            if (entity instanceof Wall || entity instanceof Brick) {
                blocksArray[countBlock][0] = entity.getX() / 32;
                blocksArray[countBlock][1] = entity.getY() / 32;
                countBlock++;
            }
        }

        aStar.setBlocks(blocksArray, countBlock);

        List<Node> path = aStar.findPath();
        if (path.size() != 0) {
            int nextY = path.get(1).getRow();
            int nextX = path.get(1).getCol();

            if (this.getY() / 32 > nextY)
                this.moveUp();
            if (this.getY() / 32 < nextY)
                this.moveDown();
            if (this.getX() / 32 > nextX)
                this.moveLeft();
            if (this.getX() / 32 < nextX)
                this.moveRight();
        }
    }
    @Override
    public void update() {
        checkBomb(this);
        if (!this.isLife()) {
            this.bombKillOnel();
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
