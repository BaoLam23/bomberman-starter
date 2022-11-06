package uet.oop.bomberman.entities.Animals;

import javafx.scene.image.Image;
import uet.oop.bomberman.control.Sound;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Items.FlameSpread;
import uet.oop.bomberman.graphics.Sprite;

import java.io.File;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.control.Menu.getTimeNumber;

public class Bomber extends Animal {


    public Bomber(int x, int y, Image img) {
        super( x, y, img);
    }

    public void bombKillPlayer() {
        bomberman.setSprite(Sprite.player_dead1.getFxImage());
    }

    @Override
    public void setSprite(Image newSprite) {
        img = newSprite;
    }

    public static void loseLife() {
        if (bomberman.getNumOfLives() > 0) {
            bomberman.setNumOfLives(bomberman.getNumOfLives() - 1);
            bomberman.makeInvincible();

            Sound.takingDamage();

            bomberman.setX(32);
            bomberman.setY(32);
            bomberman.setThrough(false);
            bomberman.setBombPass(false);
            bomberman.setSprite(Sprite.player_right.getFxImage());
        }
    }

    public void checkEnemy() {
        for (Entity entity : entities) {
            if (entity instanceof Balloom || entity instanceof Oneal || entity instanceof Minvo || entity instanceof Doll) {
                if (entity.getX() == bomberman.getX() && entity.getY() == bomberman.getY() && !invincible) {
                    loseLife();
                }
            }
        }
    }

    public void checkTime() {
        if (getTimeNumber() == 0) {
            loseLife();
        }
    }
    @Override
    public void update() {
        if (!bomberman.isBombPass()) {
            checkBomb(bomberman);
        }
        checkEnemy();
        checkTime();
        if (bomberman.getNumOfLives() == 0) {
            bomberman.setLife(false);
        }
        spriteCounter++;

        if (spriteCounter > 10) {
            if (spriteNum == 1 || spriteNum == 2)
                spriteNum++;

            else if (spriteNum == 3)
                spriteNum = 1;

            spriteCounter = 0;
        }

        if (invincible) {
            if (getSpriteNum() == 1) {
                setSprite(Sprite.player_right.getFxImage());
                if (FlameSpread.getRemainingPasses() > 0)
                    setSprite(Sprite.player_right_blue.getFxImage());
            }

            if (getSpriteNum() == 2) {
                setSprite(Sprite.transparent.getFxImage());

            }

            if (getSpriteNum() == 3) {
                setSprite(Sprite.player_right.getFxImage());
                if (FlameSpread.getRemainingPasses() > 0)
                    setSprite(Sprite.player_right_blue.getFxImage());
            }
        }

        if (!bomberman.isLife()) {
            if (getSpriteNum() == 1)
                setSprite(Sprite.player_dead1.getFxImage());

            if (getSpriteNum() == 2)
                setSprite(Sprite.player_dead2.getFxImage());

            if (getSpriteNum() == 3)
                setSprite(Sprite.player_dead3.getFxImage());

            if (bomberman.getNumOfLives() == 0) {
                bombKillPlayer();
                Image gameOver = new Image(new File("res/textures/gameOver.png").toURI().toString());

                authorView.setImage(gameOver);

                if (!root.getChildren().contains(authorView) && bomberman.getNumOfLives() == 0) {
                    root.getChildren().add(authorView);
                }
            }
        }
    }

}
