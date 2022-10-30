package uet.oop.bomberman.entities.Animals;

import javafx.scene.image.Image;
import uet.oop.bomberman.control.Blocked;
import uet.oop.bomberman.entities.Bomb;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Flame;
import static uet.oop.bomberman.BombermanGame.killObjects;
import static uet.oop.bomberman.entities.Bomb.exploded;
import static uet.oop.bomberman.graphics.Sprite.SCALED_SIZE;

public abstract class Animal extends Entity {
    private boolean life = true;
    private boolean through = false;
    private boolean bombPass = false;

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
    }
    @Override
    public void update() {

    }
}
