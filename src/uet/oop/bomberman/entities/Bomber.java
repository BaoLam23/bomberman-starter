package uet.oop.bomberman.entities;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import uet.oop.bomberman.control.Blocked;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.Bomb.hasBomb;
import static uet.oop.bomberman.graphics.Sprite.SCALED_SIZE;

public class Bomber extends Entity {
    public Bomber(int x, int y, Image img) {
        super( x, y, img);
    }

    public void bombKillPlayer(Bomber bomber) {
        bomberman.setSprite(Sprite.player_dead1.getFxImage());
    }

    @Override
    public void setSprite(Image newSprite) {
        img = newSprite;
    }

    public void moveUp() {
        if (!Blocked.blockedUp()) {
            y -= SCALED_SIZE;
        }
    }
    public void moveDown() {
        if (!Blocked.blockedDown()) {
            y += SCALED_SIZE;
        }
    }
    public void moveLeft() {
        if (!Blocked.blockedLeft()) {
            x -= SCALED_SIZE;
        }
    }
    public void moveRight() {
        if (!Blocked.blockedRight()) {
            x += SCALED_SIZE;
        }
    }

    public void checkBomb() {
        for (Entity entity : killObjects) {
            if (entity instanceof Flame) {
                if (entity.getX() == bomberman.getX() && entity.getY() == bomberman.getY()) {
                    bomberman.setLife(false);
                }
            }
            if (entity instanceof Bomb) {
                if (entity.getX() == bomberman.getX() && entity.getY() == bomberman.getY() && !hasBomb) {
                    bomberman.setLife(false);
                }
            }
        }
    }
    @Override
    public void update() {
        checkBomb();
        spriteCounter++;

        if (spriteCounter > 10) {
            if (spriteNum == 1 || spriteNum == 2)
                spriteNum++;

            else if (spriteNum == 3)
                spriteNum = 1;

            spriteCounter = 0;
        }
        if (!bomberman.isLife()) {
            bombKillPlayer((Bomber) bomberman);
        }
    }
}
