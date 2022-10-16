package uet.oop.bomberman.entities.Animals;

import javafx.scene.image.Image;
import uet.oop.bomberman.control.Blocked;
import uet.oop.bomberman.control.Sound;
import uet.oop.bomberman.entities.Bomb;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Flame;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.Bomb.hasBomb;
import static uet.oop.bomberman.graphics.Sprite.SCALED_SIZE;

public class Bomber extends Animal {
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


//    public void checkBomb() {
//        for (Entity entity : killObjects) {
//            if (entity instanceof Flame) {
//                if (entity.getX() == bomberman.getX() && entity.getY() == bomberman.getY()) {
//                    bomberman.setLife(false);
//                }
//            }
//            if (entity instanceof Bomb) {
//                if (entity.getX() == bomberman.getX() && entity.getY() == bomberman.getY() && !hasBomb) {
//                    bomberman.setLife(false);
//                }
//            }
//        }
//    }

    public void checkEnemy() {
        for (Entity entity : entities) {
            if (entity instanceof Balloom || entity instanceof Oneal) {
                if (entity.getX() == bomberman.getX() && entity.getY() == bomberman.getY()) {
                    bomberman.setLife(false);
                }
            }
        }


    }
    @Override
    public void update() {
        checkBomb(bomberman);
        checkEnemy();
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
