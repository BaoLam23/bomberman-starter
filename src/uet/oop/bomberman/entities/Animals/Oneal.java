package uet.oop.bomberman.entities.Animals;

import javafx.scene.image.Image;
import uet.oop.bomberman.control.Sound;
import uet.oop.bomberman.entities.Entity;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static uet.oop.bomberman.BombermanGame.entities;
import static uet.oop.bomberman.BombermanGame.stillObjects;

public class Oneal extends Animal {
    private int moveNum = 1;

    public Oneal(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {
//        for (Entity e : entities) {
//            if (e instanceof Balloom) {
//                ((Balloom) e).moveLeft();
//                System.out.println("found");
//            }
//        }

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
