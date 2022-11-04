package uet.oop.bomberman.entities.Animals;

import javafx.scene.image.Image;
import uet.oop.bomberman.control.Blocked;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.Items.Bombpass;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.killObjects;
import static uet.oop.bomberman.BombermanGame.stillObjects;
import static uet.oop.bomberman.entities.Bomb.exploded;
import static uet.oop.bomberman.graphics.Sprite.SCALED_SIZE;

public abstract class Animal extends Entity {
    private boolean life = true;
    private boolean through = false;
    private boolean bombPass = false;

    private int speed = 2;

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
    public void setThrough(boolean through) {
        this.through = through;
    }

    public boolean isThrough() {
        return through;
    }

    public void setBombPass(boolean bombPass) {
        this.bombPass = bombPass;
    }

    public boolean isBombPass() {
        return bombPass;
    }

    public void setCountToRun(int countToRun) {
        this.countToRun = countToRun;
    }

    public int getCountToRun() {
        return countToRun;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
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
    public void checkBomb(Animal animal) {
        for (Entity entity : killObjects) {
            if (entity instanceof Flame) {
                if (entity.getX() == animal.getX() && entity.getY() == animal.getY()) {
                    animal.setLife(false);
                }
            } else if (entity instanceof Bomb) {
                if (entity.getX() == animal.getX() && entity.getY() == animal.getY() && exploded) {
                    animal.setLife(false);
                }
            }
        }
        if (!animal.isLife()) {
            Entity object = new Grass(animal.getX() / 32, animal.getY() / 32, Sprite.skull.getFxImage());
            stillObjects.add(object);
        }
    }
    public void checkTrap(Animal animal) {
        if (animal instanceof Bomber) {
            return;
        }
        for (Entity entity : killObjects) {
            if (entity instanceof Trap) {
                if (entity.getX() == animal.getX() && entity.getY() == animal.getY()) {
                    animal.setLife(false);
                    killObjects.remove(entity);
                }
            }
        }
        if (!animal.isLife()) {
            Entity object = new Grass(animal.getX() / 32, animal.getY() / 32, Sprite.skull.getFxImage());
            stillObjects.add(object);
        }
    }

    @Override
    public void update() {

    }
}
