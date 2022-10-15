package uet.oop.bomberman.entities.Animals;

import javafx.scene.image.Image;
import uet.oop.bomberman.control.Sound;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static uet.oop.bomberman.BombermanGame.entities;
import static uet.oop.bomberman.BombermanGame.stillObjects;

public class Balloom extends Animal {
    private int moveNum = 1;

    public Balloom(int x, int y, Image img) {
        super(x, y, img);
    }

    public void bombKillBalloom() {
        //this.setSprite(Sprite.balloom_dead.getFxImage());
        entities.remove(this);
    }

    @Override
    public void update() {
        checkBomb(this);
        if (!this.isLife()) {
            this.bombKillBalloom();
        }

        moveNum++;

        int dir = (int) (Math.random() * 4 + 1);
        if(moveNum > 40) {
            switch (dir) {
                case 1: {
                    this.moveLeft();
                    break;
                }
                case 2: {
                    this.moveRight();
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

    }

}
