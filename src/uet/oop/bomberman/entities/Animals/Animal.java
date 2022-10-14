package uet.oop.bomberman.entities.Animals;

import javafx.scene.image.Image;
import uet.oop.bomberman.control.Blocked;
import uet.oop.bomberman.entities.Entity;

import static uet.oop.bomberman.graphics.Sprite.SCALED_SIZE;

public abstract class Animal extends Entity {
    private boolean life = true;

    private int countToRun = 0; //delay khi di chuyen
    public Animal(int x, int y, Image img) {
        super( x, y, img);
    }

    public Animal(int x, int y, Image img, int countToRun) {
        super( x, y, img);
        this.countToRun = countToRun;
    }

    public Animal(boolean life) {
        super();
        this.life = life;
    }
    public void setLife(boolean life) {
        this.life = life;
    }

    public boolean isLife() {
        return life;
    }

    public void setCountToRun(int countToRun) {
        this.countToRun = countToRun;
    }

    public int getCountToRun() {
        return countToRun;
    }

    public void moveUp() {
        if (!Blocked.blockedUp(this)) {
            y -= SCALED_SIZE;
        }
    }
    public void moveDown() {
        if (!Blocked.blockedDown(this)) {
            y += SCALED_SIZE;
        }
    }
    public void moveLeft() {
        if (!Blocked.blockedLeft(this)) {
            x -= SCALED_SIZE;
        }
    }
    public void moveRight() {
        if (!Blocked.blockedRight(this)) {
            x += SCALED_SIZE;
        }
    }
    @Override
    public void update() {

    }
}
